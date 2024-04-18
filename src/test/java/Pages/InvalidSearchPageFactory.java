package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvalidSearchPageFactory {
	// driver initialization
	WebDriver driver;
	WebDriverWait wait;

	public InvalidSearchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@class='lbl_input makeFlex column latoBold']")
	WebElement from;

	@FindBy(xpath = "//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]/child::div/input")
	WebElement fromCity;

	@FindBy(xpath = "//span[@data-cy=\"toCity\" and contains(@class, \"appendBottom5 textStyle\")]")
	WebElement to;

	@FindBy(xpath = "//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]/child::div/child::input")
	WebElement toCity;

	public void Source(String string) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		from.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(fromCity));

		fromCity.sendKeys(string);

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
           
		r.delay(1000);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(1000);
		
		
	}

	public void Destination(String string) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		toCity.sendKeys(string);

		
		Robot ri = new Robot();

		ri.keyPress(KeyEvent.VK_DOWN);
		ri.keyRelease(KeyEvent.VK_DOWN);
		
		ri.delay(1000);
		ri.keyPress(KeyEvent.VK_ENTER);
		ri.keyRelease(KeyEvent.VK_ENTER);
		
		ri.delay(1000);
		
	}
}
/*-----------------------------------------End of Scenario 2-----------------------------*/
