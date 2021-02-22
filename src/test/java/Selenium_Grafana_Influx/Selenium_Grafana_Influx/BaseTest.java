package Selenium_Grafana_Influx.Selenium_Grafana_Influx;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import junit.framework.Assert;


public class BaseTest {
	public WebDriver driver;
	public WebElement element;
	public WebDriverWait wait;
	long startTimer = 0;
	long finishTimer = 0; 

	@BeforeTest
	public void launchBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		driver.get("http://WWW.amazon.com");
	}
	

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}


