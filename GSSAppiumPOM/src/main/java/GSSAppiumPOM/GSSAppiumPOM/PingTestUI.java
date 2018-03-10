package GSSAppiumPOM.GSSAppiumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PingTestUI {
	
	WebDriver driver;
	public PingTestUI(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="android:id/action_bar_title")
	private WebElement barTitle;
	
	public String getTextOnTitle() {
		return barTitle.getText();
	}
	
	@FindBy(id="com.testdroid.sample.android:id/pt_et_host")
	private WebElement hostInput;
	
	public void inputHostName(String hostname) {
		hostInput.sendKeys(hostname);
	}
	
	@FindBy(id="com.testdroid.sample.android:id/pt_b_ping")
	private WebElement pingButton;
	
	public void clickOnPingButton() {
		pingButton.click();
	}
	
	@FindBy(id="com.testdroid.sample.android:id/pt_pb_pinging")
	private WebElement progressBar;
	
	public WebElement progressBar() {
		return progressBar;
	}
	
	@FindBy(id="com.testdroid.sample.android:id/pt_tv_output")
	private WebElement pingOutput;
	
	public String getTextPingOutput() {
		return pingOutput.getText();
	}


}
