package GSSAppiumPOM.GSSAppiumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FunctionsUI {
	
	WebDriver driver;
	public FunctionsUI(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="android:id/action_bar_title")
	private WebElement barTitle;
	
	public String getTextOnTitle() {
		return barTitle.getText();
	}
	
	@FindBy(id="com.testdroid.sample.android:id/fc_b_ping")
	private WebElement pingTest;
	
	public PingTestUI clickOnPingTest() {
		pingTest.click();
		return new PingTestUI(driver);
	}
	
	@FindBy(id="com.testdroid.sample.android:id/fc_b_explode")
	private WebElement explodeButton;
	
	public void clickOnExplodeButton() {
		explodeButton.click();
	}
	
	
	
	
	
	

}
