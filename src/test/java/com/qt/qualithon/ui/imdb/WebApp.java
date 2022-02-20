package com.qt.qualithon.ui.imdb;

import com.qt.qualithon.TestSession;
import com.qt.qualithon.ui.Page;
import com.qt.qualithon.ui.imdb.HomePage;

/**
 * entry class to hold IMDB Web Application UI Model/Page Objects
 **/
public class WebApp extends Page{

    public WebApp(TestSession testSession){
        super(testSession);
    }

    /**
     * launch IMDb landing page in browser test session
     *
     * @return    IMDb Web Home Page page object
     **/
    public HomePage launch(){
        this.testSession.driver().get("https://www.imdb.com");
        return new HomePage(this.testSession);
    }
}
