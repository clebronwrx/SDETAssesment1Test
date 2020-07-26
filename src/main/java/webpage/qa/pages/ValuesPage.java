package webpage.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webpage.qa.base.Base;

public class ValuesPage extends Base{
	

	public ValuesPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id = "searchtext")
	private WebElement searchBox;

	@FindBy(id = "searchbutton")
	private WebElement searchBtn;

	@FindBy(xpath = "//p[2]")
	private WebElement msg;
	
	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	public void doPassVals(String values) {
		searchBox.sendKeys(values);
		searchBtn.click();

	}

	public String getText(String expectedValue) {
		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.textToBePresentInElement(msg, expectedValue));
		String text = msg.getText();
		return text;

	}
}