package com.syntax.class10.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://aa.com/homePage.do");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement departureDate = driver.findElement(By.className("ui-datepicker-trigger"));
        departureDate.click();
        WebElement depMonth = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
        String departureText = depMonth.getText();
        while(!departureText.equalsIgnoreCase("December")){
            WebElement next = driver.findElement(By.xpath("//a[@data-handler = 'next']"));
            next.click();
            depMonth = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
            departureText = depMonth.getText();
        }

        List<WebElement>departureDays = driver.findElements(By.xpath("//table [@class = 'ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement departureDay:departureDays){
            if (departureDay.getText().equals("25")){
                departureDay.click();
                break;
            }
        }
        WebElement returnDate = driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]"));
        returnDate.click();
        WebElement returnMonth = driver.findElement(By.xpath("(//span[@class = 'ui-datepicker-month'])[2]"));
        String returnText = returnMonth.getText();
        while(!returnText.equals("February")){
            WebElement returnNext = driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
            returnNext.click();
            returnMonth = driver.findElement(By.xpath("(//span[@class = 'ui-datepicker-month'])[2]"));
            returnText = returnMonth.getText();
        }
        List<WebElement>returnDays = driver.findElements(By.xpath("//table [@class = 'ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement returnDay:returnDays){
            if (returnDay.getText().equals("14")){
                returnDay.click();
                break;
            }
        }
        WebElement originAirport = driver.findElement(By.id("reservationFlightSearchForm.originAirport"));
        originAirport.click();
        originAirport.sendKeys("IAD");

        WebElement destinationAirport = driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"));
        destinationAirport.click();
        destinationAirport.sendKeys("MNL", Keys.ENTER);
        driver.quit();
//        WebElement countryCode = driver.findElement(By.id("countryCode"));
//        countryCode.click();
//        Select selectOrigin = new Select(countryCode);
//        selectOrigin.selectByVisibleText("United States");
//
//        WebElement stateCode = driver.findElement(By.id("stateCode"));
//        stateCode.click();
//        Select selectOriginState = new Select(stateCode);
//        selectOriginState.selectByVisibleText("District of Columbia");
//
//        List<WebElement> airportOrigin = driver.findElements(By.xpath("//table[@id = 'airportsSection']/tbody/tr/td"));
//        for(WebElement airport:airportOrigin){
//            if(airport.getText().equals("IAD")){
//                airport.click();
//            }
//        }
    }
}
