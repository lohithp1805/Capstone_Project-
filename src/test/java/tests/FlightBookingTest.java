package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ConfirmationPage;
import pages.FlightsPage;
import pages.HomePage;
import pages.PurchasePage;

public class FlightBookingTest extends BaseTest {

    @Test(priority = 1)
    public void searchFlightsTest() {

        HomePage home = new HomePage(driver);

        home.selectDepartureCity("Boston");
        home.selectDestinationCity("London");
        home.clickFindFlights();

        FlightsPage flights = new FlightsPage(driver);

        Assert.assertTrue(flights.verifyFlightsDisplayed());
    }

    @Test(priority = 2)
    public void selectFlightTest() {

        HomePage home = new HomePage(driver);

        home.selectDepartureCity("Boston");
        home.selectDestinationCity("London");
        home.clickFindFlights();

        FlightsPage flights = new FlightsPage(driver);

        flights.chooseFlight();

        Assert.assertTrue(driver.getTitle().contains("Purchase"));
    }

    @Test(priority = 3)
    public void enterPassengerDetailsTest() {

        HomePage home = new HomePage(driver);

        home.selectDepartureCity("Boston");
        home.selectDestinationCity("London");
        home.clickFindFlights();

        FlightsPage flights = new FlightsPage(driver);

        flights.chooseFlight();

        PurchasePage purchase = new PurchasePage(driver);

        purchase.enterPassengerDetails();
    }

    @Test(priority = 4)
    public void completeBookingTest() {

        HomePage home = new HomePage(driver);

        home.selectDepartureCity("Boston");
        home.selectDestinationCity("London");
        home.clickFindFlights();

        FlightsPage flights = new FlightsPage(driver);

        flights.chooseFlight();

        PurchasePage purchase = new PurchasePage(driver);

        purchase.enterPassengerDetails();
        purchase.enterPaymentDetails();
        purchase.clickPurchaseFlight();

        ConfirmationPage confirm = new ConfirmationPage(driver);

        Assert.assertTrue(confirm.verifyBookingSuccess());
    }
}