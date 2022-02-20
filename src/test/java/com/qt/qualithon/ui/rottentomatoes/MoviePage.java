package com.qt.qualithon.ui.rottentomatoes;

import com.qt.qualithon.TestSession;
import com.qt.qualithon.ui.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * page object class represents elements and actions on the Rotten Tomatoes Movie Page
 **/
public class MoviePage extends Page{

    public MoviePage(TestSession testSession){
        super(testSession);

             this.testSession.driverWait().until(
            ExpectedConditions.presenceOfElementLocated(
              By.cssSelector("h1[slot='title']")));
       

    }

    /**
     * get movie title
     *
     * @return    movie title
     **/
    public String title(){
        return this.testSession.driverWait().until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("h1[slot='title']")
            ) 
        ).getText();
    }

    /**
     * get movie director name
     *
     * @return    movie director name
     **/
    public String director(){
        List<WebElement> credits = this.testSession.driverWait().until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(
              By.cssSelector("li[data-qa='movie-info-item']")));

        // traverse credits sections to find the section with Directors
        for(WebElement credit:credits){
            try{
                if(credit.findElement(By.cssSelector("div")).getText().equalsIgnoreCase("Director:")){
                    // find director name from child element of section
                    return credit.findElement(By.cssSelector("a")).getText();
                }
            }catch(NoSuchElementException e){}
        }
        throw new NoSuchElementException("Failed to lookup Director on page");
    }

    /**
     * get list of movie genres
     *
     * @return    list of movie genres
     **/
    public List<String> genres(){
        List<String> genres = new ArrayList<>();
        List<WebElement> credits = this.testSession.driverWait().until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(
              By.cssSelector("li[data-qa='movie-info-item']")));

        // traverse credits sections to find the section with Writers
        for(WebElement credit:credits){
            try{
                if(credit.findElement(By.cssSelector("div")).getText().equalsIgnoreCase("Genre:")){
                    String[] genresArr = credit.findElement(By.cssSelector("div.genre")).getText().split(",");
                    for(int i = genresArr.length-1; i >= 0 ; i--){
                        genres.add(genresArr[i].trim());
                    }
                    break;
                }
            }catch(NoSuchElementException e){}
        }
        
        // if genres list is empty throw exception
        if(genres.isEmpty()){
            throw new NoSuchElementException("Could not lookup genres on Movie page");
        }
        return genres;
    }
    
    /**
     * get movie release year
     *
     * @return    movie release year
     **/
    public String releaseYear(){
        String returnText = this.testSession.driverWait().until(
            ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("p[slot='info']")
            ) 
        ).getText().split(",")[0];
        return returnText;
    }

    /**
     * get list of movie writers
     *
     * @return    list of movie writer names
     **/
    public List<String> writers(){
        List<String> writers = new ArrayList<>();
        List<WebElement> credits = this.testSession.driverWait().until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(
              By.cssSelector("li[data-qa='movie-info-item']")));

        // traverse credits sections to find the section with Writers
        for(WebElement credit:credits){
            try{
                if(credit.findElement(By.cssSelector("div")).getText().equalsIgnoreCase("Writer:")){
                     // traverse list of writers on page to add to writers list
                     List<WebElement> writersElements = credit.findElements(By.cssSelector("a"));
                     for(int i = writersElements.size()-1; i >= 0 ; i--){
                         writers.add(writersElements.get(i).getText());
                     }
                    break;
                }
            }catch(NoSuchElementException e){}
        }

        // if writers list is empty throw exception
        if(writers.isEmpty()){
            throw new NoSuchElementException("Could not lookup Writers on movie page");
        }
        return writers;
    }

    /**
     * get movie maturity rating
     *
     * @return    movie maturity rating
     **/
    public String maturityRating(){
        String returnText = this.testSession.driverWait().until(
            ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("score-board.scoreboard")
            ) 
        ).getShadowRoot().findElement(By.cssSelector("span#rating")).getText();
        return returnText;
    }

    /**
     * get movie rating
     *
     * @return    movie rating
     **/
    public String movieRating(){
        String returnText = this.testSession.driverWait().until(
            ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("score-board.scoreboard")
            ) 
        ).getShadowRoot().findElement(By.cssSelector("score-icon-critic"))
        .getShadowRoot().findElement(By.cssSelector("span.percentage")).getText();
        return returnText;
    }
}
