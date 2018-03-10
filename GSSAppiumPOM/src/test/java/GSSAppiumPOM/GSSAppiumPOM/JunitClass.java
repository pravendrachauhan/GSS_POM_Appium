package GSSAppiumPOM.GSSAppiumPOM;

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

import io.appium.java_client.android.AndroidDriver;

public class JunitClass {
	AndroidDriver driver;
	@BeforeMethod
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
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.closeApp();
	}

}
