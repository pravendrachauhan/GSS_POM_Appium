package GSSAppiumPOM.GSSAppiumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageUI {
	WebDriver driver;
	public MainPageUI(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="com.testdroid.sample.android:id/mm_iv_title")
	private WebElement testDroidLogo;
	
	public WebElement testDroidLogo() {
		return testDroidLogo;
	}
	
	@FindBy(id="com.testdroid.sample.android:id/mm_b_native")
	private WebElement nativeActivityButton;
	
	public void clickOnNativeElement() {
		nativeActivityButton.click();
	}
	
	@FindBy(id="com.testdroid.sample.android:id/mm_b_hybrid")
	private WebElement hybridActivityButton;
	
	public void clickOnHybridElement() {
		hybridActivityButton.click();
	}
	
	@FindBy(id="com.testdroid.sample.android:id/mm_b_functions")
	private WebElement functionsButton;
	
	public FunctionsUI clickOnFunctionsElement() {
		functionsButton.click();
		return new FunctionsUI(driver);
	}
	
	@FindBy(id="com.testdroid.sample.android:id/mm_b_deviceInfo")
	private WebElement deviceInfoButton;
	
	public void clickOnDeviceInfoButton() {
		deviceInfoButton.click();
	}
	
	@FindBy(id="com.testdroid.sample.android:id/mm_b_settings")
	private WebElement settingsButton;
	
	public void clickOnSettingsButton() {
		settingsButton.click();
	}
	

}
