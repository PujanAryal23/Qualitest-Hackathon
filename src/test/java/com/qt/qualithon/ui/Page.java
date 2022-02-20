package com.qt.qualithon.ui;

import com.qt.qualithon.TestSession;

/**
 * Abtract base page to hold all default and design implementations of any generic web page
 **/
public abstract class Page {
    
    public TestSession testSession;

    public Page(TestSession testSession){
        this.testSession = testSession;
    }

    public void sleep(Integer seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch(Exception e){}
    }
}
