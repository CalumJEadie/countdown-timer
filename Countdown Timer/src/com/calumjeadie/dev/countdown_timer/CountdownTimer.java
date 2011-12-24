package com.calumjeadie.dev.countdown_timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CountdownTimer extends JFrame {

    private JPanel panel;
    
    public CountdownTimer() {
        
       // Set up window.
        
       setTitle("Countdown Timer");
       setSize(300, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       panel = new JPanel();
       getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CountdownTimer ct = new CountdownTimer();
                ct.setVisible(true);
            }
        });
    }
}