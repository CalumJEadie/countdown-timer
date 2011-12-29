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

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JLabel;

/*
 * Based on the clock example at http://www.leepoint.net/notes-java/examples/animation/41TextClock/30textclock2.html.
 */
public class CountdownTimer extends JLabel {

    javax.swing.Timer timer;
    Calendar targetDate;

    public CountdownTimer(Calendar targetDate) {
        
        super("XX:XX:XX");
        
        this.targetDate = targetDate;
        
        timer = new javax.swing.Timer(1000, new UpdateTimerAction());
        timer.start();
        
    }

    private class UpdateTimerAction implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            
            Calendar now = Calendar.getInstance();
            
            int SECOND = 1000;
            int MINUTE = 1000 * 60;
            int HOUR = 1000 * 60 * 60;
            
            long diffMillis = targetDate.getTimeInMillis() - now.getTimeInMillis(); 
            
            if( diffMillis <= 0 ) {
                setText("00:00:00");
            }else{
                long hours = diffMillis / HOUR;
                diffMillis %= HOUR;
                long minutes = diffMillis / MINUTE;
                diffMillis %= MINUTE;
                long seconds = diffMillis / SECOND;
                setText(String.format("%02d:%02d:%02d",hours,minutes,seconds));
            }
        }
        
    }
}
