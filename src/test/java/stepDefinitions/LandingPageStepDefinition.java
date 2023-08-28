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
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageproductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;

	public LandingPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	
		
	@Given("User is on GreenKart Landing page")
	public void user_is_on_green_kart_landing_page() {
		
	    }

	@When("user searched with Shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItems(shortname);
		
//		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
		
	    Thread.sleep(2000);
	    testContextSetup.landingPageproductName = landingPage.getProductName().split("-")[0].trim();
	    System.out.println(testContextSetup.landingPageproductName + " is extracted from Home page ");
	}

	



}
