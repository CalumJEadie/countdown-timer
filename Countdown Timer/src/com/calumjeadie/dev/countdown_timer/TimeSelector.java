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

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TimeSelector extends JFrame {
    
    private SpinnerDateModel targetDateModel;

    TimeSelector() {
        
        super();
        
        createGUI();
        
    }

    private void createGUI() {
        
        setTitle("Countdown Timer");
        setResizable(false);
        //setMinimumSize(new Dimension(300,0));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(0,1,10,10)); // 1 column, as many rows as necessary
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        
        JLabel label = new JLabel("Select a time");
        label.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        
        panel.add(label);
        
        Date now = new Date();
        targetDateModel = new SpinnerDateModel(now,now,null,Calendar.MILLISECOND);

        JSpinner spinner = new JSpinner(targetDateModel);
        //spinner.setPreferredSize(new Dimension(100,40));
       
        JSpinner.DateEditor spinnerEditor = new JSpinner.DateEditor(spinner,"HH:mm:ss dd/MM/yyyy");
        //spinnerEditor.
        spinner.setEditor(spinnerEditor);
        
        JFormattedTextField spinnerField = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
        spinnerField.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        
        ChangeListener l = new ChangeListener() {
            
            public void stateChanged(ChangeEvent e) {
                SpinnerModel source = (SpinnerModel) e.getSource();
                System.out.println(source.getValue());
            }
            
        };
        
        panel.add(spinner);
        
        JButton countdownButton = new JButton("Start Countdown");
        countdownButton.setPreferredSize(new Dimension(60,0));
        
        countdownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //doCountdown();
                showDate();
            }
        });
        
        
        
        panel.add(countdownButton);
        
        add(panel);
        
        pack();

        setLocationRelativeTo(null); // Call after pack so appears in the middle.
    }
    
    public void doCountdown() {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //CountdownTimerFrame ct = new CountdownTimerFrame();
                
                //ct.setVisible(true);
            }
        });
    }
    
    public void showDate() {
        System.out.println(targetDateModel.getDate().toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TimeSelector ts = new TimeSelector();
                ts.setVisible(true);
            }
        });
    }
    
}
