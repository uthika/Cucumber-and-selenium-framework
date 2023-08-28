package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	public WebDriver driver;
	public String landingPageproductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;

	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}



	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page(String shortname) throws InterruptedException {
		
		switchToOffersPage();
	
//		pageObjectManager = new PageObjectManager(testContextSetup.driver);
		
		OfferPage offerPage = testContextSetup.pageObjectManager.OfferPage();
		offerPage.searchItem(shortname);
		
	   
	    Thread.sleep(2000);
	    offerPageProductName = offerPage.getProductName();
	    
	}
	
	public void switchToOffersPage()
	{
		//if switched to offer page ->skip below part
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://www.rahulshettyacademy.com/seleniumPractise/#/offers"))
		//pageObjectManager = new PageObjectManager(testContextSetup.driver);
		
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
	    testContextSetup.genericUtils.switchWindowToChild();
	}
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	    Assert.assertEquals(offerPageProductName,testContextSetup.landingPageproductName);
	}
}
