package webpage.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webpage.qa.base.Base;

import org.openqa.selenium.WebDriver;

public class HomePage extends Base{
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//a[contains(text(),\"Find '1 2 3'\")]")
	private WebElement findTab;

	public void doClickonFindTab() {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(findTab));
		findTab.click();

	}
}
