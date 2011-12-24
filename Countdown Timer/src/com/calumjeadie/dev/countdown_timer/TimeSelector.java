package com.calumjeadie.dev.countdown_timer;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;

public class TimeSelector extends JFrame {
    
    private JPanel panel;
    private Date targetDate;
    private SpinnerDateModel targetDateModel;
    
    TimeSelector() {
        
        super();
        
        initUI();
        
    }

    private void initUI() {
        
        setTitle("Countdown Timer");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel = new JPanel(new BorderLayout(20,20));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel label = new JLabel("Select a time");
        label.setFont(new Font("Georgia", Font.PLAIN, 14));
        
        panel.add(label, BorderLayout.CENTER);
        
        targetDate = new Date();
        targetDateModel = new SpinnerDateModel(targetDate,new Date(),null,Calendar.MILLISECOND);

        JSpinner spinner = new JSpinner(targetDateModel);
        
        add(panel);
        
        pack();
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