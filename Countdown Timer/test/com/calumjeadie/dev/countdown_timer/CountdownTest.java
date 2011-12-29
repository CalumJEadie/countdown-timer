package com.calumjeadie.dev.countdown_timer;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;

import org.junit.Test;

public class CountdownTest {
    
    @Test
    public void testGetFontSize() throws Exception {
        
        System.out.println(Countdown.getFontSize(1000));
        System.out.println(Countdown.getFontSize(1280));
        System.out.println(Countdown.getFontSize(1281));
        
        fail();   
        
    }
}
