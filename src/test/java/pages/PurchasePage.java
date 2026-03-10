package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PurchasePage {

    WebDriver driver;

    public PurchasePage(WebDriver driver){
        this.driver=driver;
    }

    By name = By.id("inputName");
    By address = By.id("address");
    By city = By.id("city");
    By state = By.id("state");
    By zip = By.id("zipCode");
    By cardType = By.id("cardType");
    By cardNumber = By.id("creditCardNumber");
    By cardMonth = By.id("creditCardMonth");
    By cardYear = By.id("creditCardYear");
    By nameOnCard = By.id("nameOnCard");
    By purchaseFlight = By.xpath("//input[@value='Purchase Flight']");
    By rememberMe = By.id("rememberMe");

    public void enterPassengerDetails(){

        driver.findElement(name).sendKeys("Lohith");
        driver.findElement(address).sendKeys("Gagan Vihar Appartments flat no 15");
        driver.findElement(city).sendKeys("Hyderabad");
        driver.findElement(state).sendKeys("Telangana");
        driver.findElement(zip).sendKeys("500029");
    }

    public void enterPaymentDetails(){

    	Select select = new Select(driver.findElement(cardType));
        select.selectByVisibleText("Visa");

        driver.findElement(cardNumber).sendKeys("12345678905");
        driver.findElement(cardMonth).clear();
        driver.findElement(cardMonth).sendKeys("12");
        driver.findElement(cardYear).clear();
        driver.findElement(cardYear).sendKeys("2028");
        driver.findElement(nameOnCard).sendKeys("Lohith");
        driver.findElement(rememberMe).click();
    }

    public void clickPurchaseFlight(){
        driver.findElement(purchaseFlight).click();
    }
}