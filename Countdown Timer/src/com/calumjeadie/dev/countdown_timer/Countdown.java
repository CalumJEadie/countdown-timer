/*******************************************************************************
 * Copyright (c) 2011 Calum J. Eadie.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * http://www.opensource.org/licenses/MIT
 * 
 * Contributors:
 *     Calum J. Eadie - initial API and implementation
 ******************************************************************************/

package com.calumjeadie.dev.countdown_timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Countdown {
    
    private Calendar targetDate;
    private JFrame frame;
    private JPanel panel;
    private CountdownTimer countdown;
    private Color backgroundColor;
    private Color foregroundColor;
    private Font font;
    private String title;
    private int screenDevice = 0;

    public Countdown(Calendar targetDate) {
        
        this.targetDate = targetDate;
        
        this.backgroundColor = Color.BLACK;
        this.foregroundColor = Color.WHITE;
        this.font = new Font(Font.MONOSPACED, Font.PLAIN, 200);
        this.title = "Countdown Timer - (C) 2011 Calum J. Eadie; MIT License";
        
        setupGUI();
        
    }
    
    private void setupGUI() {
        
        // Set up countdown.
        countdown = new CountdownTimer(targetDate);
        countdown.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        countdown.setFont(font);
        countdown.setHorizontalAlignment(SwingConstants.CENTER);
        countdown.setForeground(foregroundColor);
        
        // Set up panel.
        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new BorderLayout(50,50));

        panel.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                toggleFullscreen();
            }
            
        });
        
        panel.add(countdown);
        
        // Set up frame.
        displayNormal();
    }
    
    private void toggleFullscreen() {
        if( frame.isUndecorated() ) {
            displayNormal();
        }else{
            displayFullscreen();
        }
    }
    
    private void displayFullscreen() {

        if( frame != null ) {
            frame.dispose();
        }

        SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 
                 frame = new JFrame();
          
                 frame.setTitle(title);
                 //setMinimumSize(new Dimension(800, 400));
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 frame.setUndecorated(true);
                 
                 frame.add(panel);

                 // Make full screen. Toggle between the device to make the window full screen on.
                 //GraphicsConfiguration gc = frame.getGraphicsConfiguration();
                 //GraphicsDevice gd = gc.getDevice();
                 GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                 GraphicsDevice[] gds = ge.getScreenDevices();
                 GraphicsDevice gd = gds[screenDevice % gds.length];
                 
                 countdown.setFont(font.deriveFont(getFontSize(gd.getDisplayMode().getWidth())));
                 
                 gd.setFullScreenWindow(frame);
                 
                 frame.setVisible(true);
                 
                 screenDevice++;
                 
             }
         });
    }
    
    private void displayNormal() {
     
       if( frame != null ) {
           frame.dispose();
       }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                frame = new JFrame();
         
                frame.setTitle(title);
                //setMinimumSize(new Dimension(800, 400));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                frame.add(panel);
                
                countdown.setFont(font);
                
                frame.pack();
                
                frame.setLocationRelativeTo(null); 
                
                frame.setVisible(true);
                
            }
        });
        
    }
    
    /*
     * Calculated the font size for a given display width.
     */
    public static float getFontSize(int width) {
        
        // For Font.MONOSPACED font have height to width ratio of ~ 2.
        // Have 8 characters, so for height h expect width of ~ 4h.
        
        return width/6;
    }
    
}
