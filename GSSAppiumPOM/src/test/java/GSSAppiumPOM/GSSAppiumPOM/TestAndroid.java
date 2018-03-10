package GSSAppiumPOM.GSSAppiumPOM;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TestAndroid {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		//Create Desired Capability Object
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "192.168.56.101:5555");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6");
		cap.setCapability("app", "/Users/pravendrachauhan/Downloads/Testdroid.apk");
		cap.setCapability("appPackage", "com.testdroid.sample.android");
		cap.setCapability("appActivity", "com.testdroid.sample.android.MM_MainMenu");
		//Create Android Driver using created Desired Capability Object
		AndroidDriver driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		System.out.println("Android Driver is started");
		Thread.sleep(10000);
		//Find Native Element Object
		MainPageUI mainPage=new MainPageUI(driver);
		FunctionsUI functionUI = mainPage.clickOnFunctionsElement();
		Thread.sleep(10000);
		PingTestUI pingTestUI = functionUI.clickOnPingTest();
		Thread.sleep(10000);
		pingTestUI.inputHostName("google.com");
		Thread.sleep(10000);
		pingTestUI.clickOnPingButton();
		//Wait for Loading to complete
		Thread.sleep(10000);
		String outputValue = pingTestUI.getTextPingOutput();
		
		System.out.println(outputValue);
		Thread.sleep(10000);

		System.out.println("Application is Going to close");
		//Close Application
		driver.closeApp();
		System.out.println("Application is Closed");
	}

}
