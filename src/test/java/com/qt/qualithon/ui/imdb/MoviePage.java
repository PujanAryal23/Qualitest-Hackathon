package com.qt.qualithon.ui.imdb;

import com.qt.qualithon.TestSession;
import com.qt.qualithon.ui.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;

/**
 * page object class represents elements and actions on the IMDb Movie Page
 **/
public class MoviePage extends Page{

    public MoviePage(TestSession testSession){
        super(testSession);

        // adjust page for tablet formfactor
        WebElement showMoreLink = this.testSession.driverWait().until(
            ExpectedConditions.presenceOfElementLocated(
              By.cssSelector("a[data-testid='title-pc-expand-more-button']")));
       
        if(showMoreLink.isDisplayed()){
            showMoreLink.click();
        }

    }

    /**
     * get movie title
     *
     * @return    movie title
     **/
    public String title(){
        return this.testSession.driverWait().until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("h1[data-testid='hero-title-block__title']")
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
              By.cssSelector("li.ipc-metadata-list__item")));

        // traverse credits sections to find the section with Directors
        for(WebElement credit:credits){
            try{
                if(credit.findElement(By.cssSelector("span")).getText().equalsIgnoreCase("Director")){
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
              By.cssSelector("li.ipc-metadata-list__item")));

        // traverse credits sections to find the section with Writers
        for(WebElement credit:credits){
            try{
                if(credit.findElement(By.cssSelector("span")).getText().equalsIgnoreCase("Genres")){
                    // traverse list of writers on page to add to writers list
                    List<WebElement> writersElements = credit.findElements(By.cssSelector("a"));
                    for(int i = writersElements.size()-1; i >= 0 ; i--){
                        genres.add(writersElements.get(i).getText());
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
                By.cssSelector("ul[data-testid='hero-title-block__metadata']>li:nth-of-type(1)>a")
            ) 
        ).getText();
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
              By.cssSelector("li.ipc-metadata-list__item")));

        // traverse credits sections to find the section with Writers
        for(WebElement credit:credits){
            try{
                if(credit.findElement(By.cssSelector("span,a")).getText().equalsIgnoreCase("Writers")){
                    // traverse list of writers on page to add to writers list
                    List<WebElement> writersElements = credit.findElements(By.cssSelector("li.ipc-inline-list__item>a"));
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
                By.cssSelector("ul[data-testid='hero-title-block__metadata']>li:nth-of-type(2)>a")
            ) 
        ).getText();
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
                By.cssSelector("span.AggregateRatingButton__RatingScore-sc-1ll29m0-1")
            ) 
        ).getText();
        return returnText;
    }
}
