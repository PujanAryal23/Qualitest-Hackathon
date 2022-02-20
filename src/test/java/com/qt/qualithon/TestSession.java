package com.qt.qualithon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * create and manage test sessions, browser sessions and utility functions
 **/
public class TestSession {

    public static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public TestSession(WebDriver driver){
        this.webDriver.set(driver);
    }

    /**
     * get browser driver instance
     *
     * @return    webdriver instance of browser
     **/
    public WebDriver driver(){
        return this.webDriver.get();
    }

    /**
     * webdriver wait instance
     *
     * @param     forSeconds    seconds to wait
     * @return    webdriver wait instance
     **/
    public WebDriverWait driverWait(long forSeconds){
        return new WebDriverWait(this.driver(), forSeconds);
    }

    /**
     * webdriver wait instane with wait timeout set to 30 seconds
     *
     * @return    webdriver wait instance
     **/
    public WebDriverWait driverWait(){
        return this.driverWait(30);
    }
    /**
     * webdriver wait instane with wait timeout set to 90 seconds
     *
     * @return    webdriver wait instance
     **/
    public WebDriverWait driverLongWait(){
        return this.driverWait(90);
    }
    /**
     * webdriver wait instane with wait timeout set to 10 seconds
     *
     * @return    webdriver wait instance
     **/
    public WebDriverWait driverShortWait(){
        return this.driverWait(10);
    }

    /**
     * init a Google Chrome session on local
     *
     * @return    instance of TestSession with local google chrome browser
     **/
    public static TestSession ChromeTestSession(){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:/Users/pujan/Desktop/Qualithon Hackathon/qualithon_track2.java-main/qualithon_track2.java-main/src/test/java/com/qt/qualithon/chromedriver/chromedriver.exe");
        return new TestSession(new ChromeDriver());
    }

}
