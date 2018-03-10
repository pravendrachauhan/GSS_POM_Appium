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

public class TestNGClass {
	AndroidDriver driver;
	
	@BeforeSuite
	public void setUp() throws InterruptedException, MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "192.168.56.101:5555");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6");
		cap.setCapability("app", "/Users/pravendrachauhan/Downloads/Testdroid.apk");
		cap.setCapability("appPackage", "com.testdroid.sample.android");
		cap.setCapability("appActivity", "com.testdroid.sample.android.MM_MainMenu");
		//Create Android Driver using created Desired Capability Object
		driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		System.out.println("Android Driver is started");
		Thread.sleep(10000);
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
	
	@SuppressWarnings("deprecation")
	@Test
	public void verifyPingOutput() throws InterruptedException {
		MainPageUI mainPage=new MainPageUI(driver);
		//Assert.assertTrue(mainPage.testDroidLogo().isDisplayed());
		FunctionsUI functionUI = mainPage.clickOnFunctionsElement();
		Thread.sleep(10000);
		PingTestUI pingTestUI = functionUI.clickOnPingTest();
		Thread.sleep(10000);
		pingTestUI.inputHostName("google.com");
		Thread.sleep(10000);
		pingTestUI.clickOnPingButton();
		//Wait for Loading to complete
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.testdroid.sample.android:id/pt_pb_pinging"))); 

		String outputValue = pingTestUI.getTextPingOutput();
		System.out.println(outputValue);
		AssertJUnit.assertTrue(outputValue.contains("64 bytes"));
		System.out.println("Test");
	}
	
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.closeApp();
		System.out.println("After Suite");
	}

}
