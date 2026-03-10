package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver){
        this.driver=driver;
    }

    By confirmationMessage = By.tagName("h1");

    public boolean verifyBookingSuccess(){
        String message = driver.findElement(confirmationMessage).getText();
        return message.contains("Thank you for your purchase");
        
    }
}