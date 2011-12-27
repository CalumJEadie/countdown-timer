package com.calumjeadie.dev.countdown_timer;

import java.util.Calendar;
import java.util.Date;

import javax.swing.SwingUtilities;

public class NewYearCountdownTimerFrame extends CountdownTimerFrame {

    public NewYearCountdownTimerFrame() {
        
        super(getNewYearsEveMidnight());
    }
    
    public static Calendar getNewYearsEveMidnight() {

        Calendar now = Calendar.getInstance();
        Calendar newYearsEveMidnight = Calendar.getInstance();
        newYearsEveMidnight.set(now.get(Calendar.YEAR)+1,0,0,0,0,0);
        
        return newYearsEveMidnight;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                NewYearCountdownTimerFrame frame = new NewYearCountdownTimerFrame();
                frame.setVisible(true);
            }
        });
    }

}
