
package Selenium_Grafana_Influx.Selenium_Grafana_Influx;


import java.util.Random;
import java.util.Timer;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import junit.framework.Assert;

// @Listeners(ExecutionListener.class)  // Uncomment if you want to run only this particular class 
public class TestCases extends BaseTest

{
	public static long timeElapsed = 0;
	@Test(priority = 1, description = "First Test Case", invocationCount=1)
	public void testmethod1() throws InterruptedException
	{
		Settings.testMode = "UI_Testing";
		Settings.timer = 0;
		WebElement searchBar = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
		searchBar.sendKeys("Macbook Air");
		Thread.sleep(1200);
		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
		startTimer = System.currentTimeMillis(); // Timer Started
		Thread.sleep(1200);
		WebElement searchTitle = driver.findElement(By.xpath("/html/body/div[1]/div[2]/span/div/span/h1/div/div[1]/div/div/span[3]"));
		String searchTitleText = searchTitle.getText();
		searchTitleText = searchTitleText.replace("\"", "");
		finishTimer = System.currentTimeMillis(); // Timer Stopped
		timeElapsed = finishTimer - startTimer;
		Settings.timer = timeElapsed;
		WebElement firstImage = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/span[3]/div[2]/div[1]/div/span/div/div/div/div/div[2]/div[1]/div/div/span/a/div/img"));
		firstImage.click();
		Assert.assertEquals("Macbook Air" , searchTitleText);
	}




	@Test(priority = 2, description = "Second Test Case")
	public void testmethod2() throws InterruptedException
	{
		Settings.testMode = "UI_Testing";
		Settings.timer = 0;
		Random rand = new Random(); //instance of random class
		int upperbound = 25;
		int int_random = rand.nextInt(upperbound); //generate random values from 0-24 
		Settings.timer = int_random;
		SoftAssert softAssert = new SoftAssert();
		WebElement websiteLogo = driver.findElement(By.id("nav-logo-sprites"));
		Boolean isElementPresent = websiteLogo.isDisplayed();
		softAssert.assertEquals(isElementPresent.booleanValue(), true);
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(10000);
	}
	
	
	@Test(invocationCount=1,priority = 3, description = "Third Test Case")
	public void testMethod3() throws InterruptedException
	{
		
		Settings.testMode = "UI_Testing";
		Random rand = new Random(); //instance of random class
		int upperbound = 12;
		int int_random = rand.nextInt(upperbound); //generate random values from 0-12
		Thread.sleep(int_random * 1000);
		Settings.timer = 0;
		Random rand1 = new Random(); //instance of random class
		int upperbound1 = 25;
		int int_random1 = rand1.nextInt(upperbound1); //generate random values from 0-24
		Settings.timer = int_random1;

	}

	@Test(priority = 4, description = "Forth Test Case")
	public void testCaseSkipException()
	{
		Settings.testMode = "UI_Testing";		
		throw new SkipException("Skipping this exception"); // Skipping the test case intentionally
	}
	
	@Test(priority = 5, description = "Forth Test Case")
	public void failingTestCase()
	{
		Settings.testMode = "UI_Testing";
		Assert.assertEquals(3, 1); // Failing the test case intentionally	
	}
}
