package com.calumjeadie.dev.countdown_timer;

import java.awt.Font;
import java.awt.GridLayout;
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
        
        panel = new JPanel(new GridLayout(0,1,10,10)); // 1 column, as many rows as necessary
        //GridLayout g = new GridLayout();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel label = new JLabel("Select a time");
        label.setFont(new Font("Dialog", Font.PLAIN, 16));
        
        panel.add(label);
        
        Date now = new Date();
        targetDate = now;
        targetDateModel = new SpinnerDateModel(targetDate,now,null,Calendar.MILLISECOND);

        JSpinner spinner = new JSpinner(targetDateModel);
       
        JSpinner.DateEditor spinnerEditor = new JSpinner.DateEditor(spinner,"dd/MM/yyyy H:m:s");
        
        //spinnerEditor.setFont(new Font("Georgia", Font.PLAIN, 20));
        
        panel.add(spinner);
        
        JButton countdownButton = new JButton("Start Countdown");
        
        panel.add(countdownButton);
        
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