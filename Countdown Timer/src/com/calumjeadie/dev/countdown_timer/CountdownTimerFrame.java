package com.calumjeadie.dev.countdown_timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CountdownTimerFrame extends JFrame {

    private Calendar targetDate;
    private Color backgroundColor;
    private Color foregroundColor;
    private boolean fullscreen = false;
    private CountdownTimer countdown;
    
    public CountdownTimerFrame(Calendar targetDate) {
        
        super("Countdown Timer");
        
        this.targetDate = targetDate;
        this.backgroundColor = Color.BLACK;
        this.foregroundColor = Color.WHITE;
        
        setupGUI();
    }
    
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.err);
        } catch (InstantiationException e) {
            e.printStackTrace(System.err);
        } catch (IllegalAccessException e) {
            e.printStackTrace(System.err);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace(System.err);
        }
    }
    
    private void setupFrame(JFrame frame) {

        frame.setLayout(new BorderLayout(50,50)); 
        frame.setTitle("Countdown Timer");
        setMinimumSize(new Dimension(800, 400));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        frame.getContentPane().setBackground(backgroundColor);
    }
    
    private void setupGUI() {

        setupFrame(this);
        
        setLookAndFeel();
        
        countdown = new CountdownTimer(targetDate);
        countdown.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        countdown.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 200));
        countdown.setHorizontalAlignment(SwingConstants.CENTER);
        countdown.setForeground(foregroundColor);
        
        countdown.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                toggleFullscreen();
            }
            
        });
        
        add(countdown);
        
        pack();

        setLocationRelativeTo(null); // Do so at the end so can calculate actual center.
        
        setVisible(true);
        
    }
    
    private void toggleFullscreen() {
        if( fullscreen ) {
            displayNormal();
        }else{
            displayFullscreen();
        }
    }
    
    private void displayFullscreen() {
        
        // Dispose current frame.
        dispose();
        
        // Create new frame.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                JFrame frame = new JFrame();

                setupFrame(frame);
                
                frame.add(countdown);
                
                frame.setUndecorated(true);

                pack();
                
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice gd = ge.getDefaultScreenDevice();
                gd.setFullScreenWindow(frame);
                
                setVisible(true);
                
                fullscreen = true;
            }
        });
        
    }
    
    private void displayNormal() {
        
        // Dispose current frame.
        dispose();
        
        // Create new frame.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                JFrame frame = new JFrame();

                setupFrame(frame);
                
                frame.add(countdown);
                
                pack();
                
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice gd = ge.getDefaultScreenDevice();
                gd.setFullScreenWindow(null);
                
                setLocationRelativeTo(null);
                
                setVisible(true);
                
                fullscreen = false;
            }
        });
    }
}