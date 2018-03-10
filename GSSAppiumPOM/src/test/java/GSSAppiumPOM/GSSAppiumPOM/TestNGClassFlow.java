package GSSAppiumPOM.GSSAppiumPOM;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class TestNGClassFlow {
	AndroidDriver driver;
	
	@BeforeSuite
	public void setUp() throws InterruptedException, MalformedURLException {
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	
	@Test(priority=1)
	public void zeb() throws InterruptedException {
		System.out.println("Launching App");
		Assert.fail();
	}
	
	@Test(priority=2,dependsOnMethods= {"zeb"})
	public void xml() throws InterruptedException {
		System.out.println("Logging In");
	}
	
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		System.out.println("After Suite");
	}

}
