package com.calumjeadie.dev.countdown_timer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
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
    
    public CountdownTimerFrame(Calendar targetDate) {
        
        super("Countdown Timer");
        
        this.targetDate = targetDate;
        
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
    
    private void setupGUI() {
        
        setLookAndFeel();
   
        setLayout(new BorderLayout(50,50)); 
        setTitle("Countdown Timer");
        //setMinimumSize(new Dimension(800, 400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        CountdownTimer countdown = new CountdownTimer(targetDate);
        countdown.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        countdown.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 200));
        countdown.setHorizontalAlignment(SwingConstants.CENTER);
        
        add(countdown);
        
        pack();

        setLocationRelativeTo(null); // Do so at the end so can calculate actual center.
        
    }
}