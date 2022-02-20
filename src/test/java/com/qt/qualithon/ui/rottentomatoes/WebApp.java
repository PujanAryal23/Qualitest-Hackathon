package com.qt.qualithon.ui.rottentomatoes;

import com.qt.qualithon.TestSession;
import com.qt.qualithon.ui.Page;

/**
 * entry class to hold Rotten Tomatoes Web Application UI Model/Page Objects
 **/
public class WebApp extends Page{

    public WebApp(TestSession testSession){
        super(testSession);
    }

    /**
     * launch Rotten Tomatoes landing page in browser test session
     *
     * @return    Rotten Tomatoes Web Home Page page object
     **/
    public HomePage launch(){
        this.testSession.driver().get("https://www.rottentomatoes.com");
        return new HomePage(this.testSession);
    }
}
