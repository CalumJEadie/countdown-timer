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

import java.util.Calendar;

import javax.swing.SwingUtilities;

public class NewYearEveCountdown extends Countdown {
    
    public NewYearEveCountdown() {
        
        super(getNewYearEveStart());
        
    }
    
    public static Calendar getNewYearEveStart() {

        Calendar now = Calendar.getInstance();
        Calendar newYearEveStart = Calendar.getInstance();
        newYearEveStart.set(now.get(Calendar.YEAR),Calendar.DECEMBER,31,0,0,0);
        
        return newYearEveStart;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                new NewYearEveCountdown();
                
            }
        });
    }
    
}
