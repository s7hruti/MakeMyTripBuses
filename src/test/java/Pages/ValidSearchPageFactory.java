package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ValidSearchPageFactory {
	WebDriver driver;
	WebDriverWait wait;
	

	public ValidSearchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//li[contains(@class, \"menu_Buses\") and .//a[contains(@href, \"makemytrip\")]]")
	WebElement busMenu;

	@FindBy(xpath = "//label[@class='lbl_input makeFlex column latoBold']")
	WebElement from;

	@FindBy(xpath = "//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]/child::div/input")
	WebElement fromCity;

	@FindBy(xpath = "//span[@data-cy=\"toCity\" and contains(@class, \"appendBottom5 textStyle\")]")
	WebElement to;

	@FindBy(xpath = "//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]/child::div/child::input")
	WebElement toCity;

	@FindBy(id = "travelDate")
	WebElement date1;

	@FindBy(xpath = "//button[@id='search_button']")
	WebElement search;

	public void BusSection() {
		busMenu.click();
	}

	public void Source(String string) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		from.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(fromCity));

		fromCity.sendKeys(string);

		
		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}

	public void Destination(String destination) throws InterruptedException, AWTException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toCity));
		toCity.sendKeys(destination);
        Thread.sleep(1000);
		Robot ri = new Robot();

		ri.keyPress(KeyEvent.VK_DOWN);
		ri.keyRelease(KeyEvent.VK_DOWN);
		
		ri.delay(1000);
		
		ri.keyPress(KeyEvent.VK_ENTER);
		ri.keyRelease(KeyEvent.VK_ENTER);
		
		ri.delay(1000);

	}

	public void Date() throws InterruptedException {
		WebElement selectDate = driver.findElement(By.xpath("//div[@aria-label=\"Fri May 24 2024\"]"));
		selectDate.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(search));
		

	}

	public void scrollDown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	
	}

	public void Search() {
		search.click();
	}

	/*-----------------------------------------End of Scenario 1-----------------------------*/

}