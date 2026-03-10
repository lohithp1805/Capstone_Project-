package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightsPage {

    WebDriver driver;

    public FlightsPage(WebDriver driver){
        this.driver=driver;
    }

    By flightsTable = By.xpath("//table");
    By chooseFlight = By.xpath("(//input[@type='submit'])[1]");

    public boolean verifyFlightsDisplayed(){
        return driver.findElement(flightsTable).isDisplayed();
    }

    public void chooseFlight(){
        driver.findElement(chooseFlight).click();
    }
}