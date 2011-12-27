package com.calumjeadie.dev.countdown_timer;

import java.util.Calendar;

import javax.swing.SwingUtilities;

public class NewYearCountdown extends Countdown {
    
    public NewYearCountdown() {
        
        super(getNewYearStart());
        
    }
    
    public static Calendar getNewYearStart() {

        Calendar now = Calendar.getInstance();
        Calendar newYearStart = Calendar.getInstance();
        newYearStart.set(now.get(Calendar.YEAR)+1,0,0,0,0,0);
        
        return newYearStart;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                new NewYearCountdown();
                
            }
        });
    }
    
}
