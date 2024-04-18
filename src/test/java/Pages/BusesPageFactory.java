package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusesPageFactory {
	
	WebDriver driver;
	WebDriverWait wait;

	public BusesPageFactory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//----------------------------XPATH FOR VALID SEARCH (SCENARIO 1)------------------------
	
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
	
//----------------------------XPATH FOR INVALID SEARCH (SCENARIO 2)------------------------
	
	@FindBy(xpath = "//label[@class='lbl_input makeFlex column latoBold']")
	WebElement from1;

	@FindBy(xpath = "//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]/child::div/input")
	WebElement fromCity1;

	@FindBy(xpath = "//span[@data-cy=\"toCity\" and contains(@class, \"appendBottom5 textStyle\")]")
	WebElement to1;

	@FindBy(xpath = "//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]/child::div/child::input")
	WebElement toCity1;

//----------------------------XPATH FOR FILTER 1 (SCENARIO 3)------------------------
	
	@FindBy(xpath = "//li[contains(@class, \"menu_Buses\") and .//a[contains(@href, \"makemytrip\")]]")
	WebElement busMenu2;

	@FindBy(xpath = "//label[@class='lbl_input makeFlex column latoBold']")
	WebElement from2;

	@FindBy(xpath = "//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]/child::div/input")
	WebElement fromCity2;

	@FindBy(xpath = "//span[@data-cy=\"toCity\" and contains(@class, \"appendBottom5 textStyle\")]")
	WebElement to2;

	@FindBy(xpath = "//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]/child::div/child::input")
	WebElement toCity2;

	@FindBy(id = "travelDate")
	WebElement date12;

	@FindBy(xpath = "//button[@id='search_button']")
	WebElement search2;

//----------------------------XPATH FOR FILTER 2 (SCENARIO 4)------------------------
	
	@FindBy(xpath = "//li[contains(@class, \"menu_Buses\") and .//a[contains(@href, \"makemytrip\")]]")
	WebElement busMenu3;

	@FindBy(xpath = "//label[@class='lbl_input makeFlex column latoBold']")
	WebElement from3;

	@FindBy(xpath = "//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]/child::div/input")
	WebElement fromCity3;

	@FindBy(xpath = "//span[@data-cy=\"toCity\" and contains(@class, \"appendBottom5 textStyle\")]")
	WebElement to3;

	@FindBy(xpath = "//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]/child::div/child::input")
	WebElement toCity3;

	@FindBy(id = "travelDate")
	WebElement date13;

	@FindBy(xpath = "//button[@id='search_button']")
	WebElement search3;

	@FindBy(xpath = "//div[@class='makeFlex  vrtlCenter pushLeft ' and span[@class='sc-kjoXOD erIYpE' and text()='Kharghar']]")
	WebElement pickupButton;

	@FindBy(xpath = "//div[contains(span[@class='sc-kjoXOD erIYpE'], 'Hinje Wadi')]")
	WebElement dropButton;

//----------------------------XPATH FOR SORT BY (SCENARIO 5)------------------------
	
	@FindBy(xpath = "//li[contains(@class, \"menu_Buses\") and .//a[contains(@href, \"makemytrip\")]]")
	WebElement busMenu4;

	@FindBy(xpath = "//label[@class='lbl_input makeFlex column latoBold']")
	WebElement from4;

	@FindBy(xpath = "//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]/child::div/input")
	WebElement fromCity4;

	@FindBy(xpath = "//span[@data-cy=\"toCity\" and contains(@class, \"appendBottom5 textStyle\")]")
	WebElement to4;

	@FindBy(xpath = "//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]/child::div/child::input")
	WebElement toCity4;

	@FindBy(id = "travelDate")
	WebElement date4;

	@FindBy(xpath = "//button[@id='search_button']")
	WebElement search4;

	@FindBy(xpath = "//li[text()='Fastest']")
	WebElement fastest;
	
	@FindBy(xpath = "//li[text()='cheapest']")
	WebElement cheapest;

//----------------------------METHODS FOR VALID SEARCH (SCENARIO 1)------------------------
	
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
	
//----------------------------METHODS FOR INVALID SEARCH (SCENARIO 2)------------------------
	
	public void Source1(String string) throws InterruptedException, AWTException {
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

	public void Destination1(String string) throws InterruptedException, AWTException {
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
	
//----------------------------METHODS FOR FILTER 1 (SCENARIO 3)------------------------
	
	public void BusSection2() {
		busMenu.click();
	}

	public void Source2(String string) throws InterruptedException, AWTException {
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

	public void Destination2(String destination) throws InterruptedException, AWTException {

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

	public void Date2() throws InterruptedException {
		WebElement selectDate = driver.findElement(By.xpath("//div[@aria-label=\"Fri May 24 2024\"]"));
		selectDate.click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(search));
	}

	public void scrollDown2() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	}

	public void Search2() {
		search.click();
	}

	public void selectNonAC() {
		WebElement nonAC = driver.findElement(By.xpath("//div[contains(@class, 'horiFilterBtn') and contains(@class, 'false')]"));
		nonAC.click();
	}

	public void selectSleeper() {
		WebElement sleeper = driver.findElement(By.xpath("//div[span[contains(text(), 'Sleeper')]]"));
		sleeper.click();
	}

	public void clickOnSingleSeater() {
		WebElement singleSeater = driver.findElement(By.xpath("//span[@class='checkmarkOuter']"));
		singleSeater.click();
	}

	public String getMessage2() {

		WebElement e = driver.findElement(By.xpath("//p[@class='latoBold secondaryTxt font14']"));
		String msg = e.getText();
		return msg;
	}

//----------------------------METHODS FOR FILTER 2 (SCENARIO 4)------------------------
	
	public void BusSection3() {
		busMenu.click();
	}

	public void Source3(String string) throws InterruptedException, AWTException {
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

	public void Destination3(String destination) throws InterruptedException, AWTException {

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

	public void Date3() throws InterruptedException {
		WebElement selectDate = driver.findElement(By.xpath("//div[@aria-label=\"Fri May 24 2024\"]"));
		selectDate.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(search));
	}

	public void Search3() {
		search.click();
	}

	public void selectPickUpPoint(String string) throws InterruptedException {
		WebElement pickup = driver.findElement(By.xpath("//input[@id='Pick up point' and @class='filterSearchInp']"));
		pickup.sendKeys(string);
		Thread.sleep(1000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pickupButton));
		pickupButton.click();
		Thread.sleep(1000);

	}

	public void selectDropPoint(String string) throws InterruptedException {
		WebElement drop = driver.findElement(By.id("Drop point"));
		drop.sendKeys(string);
		Thread.sleep(1000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dropButton));
		dropButton.click();
		Thread.sleep(1000);
	}

	public void selectTravelOperator(String string) {
		WebElement travelOperator = driver.findElement(By.id("Travel Operators"));
		travelOperator.sendKeys(string);
		WebElement travelOperatorButton = driver.findElement(By.xpath("//div[@class='makeFlex  vrtlCenter pushLeft ']/span[@class='sc-kjoXOD erIYpE' and text()='VRL Travels']"));
		travelOperatorButton.click();
	}

	public String getMessage3() {
		// TODO Auto-generated method stub
		WebElement e = driver.findElement(By.xpath("//p[@class=\"latoBold secondaryTxt font14\"]"));
		String msg = e.getText();
		return msg;
	}
	
	public void scrollDown30() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
	}

	public void scrollUp30() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(1000);
	}

	public void scrollDown31() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
	}

	public void scrollUp31() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-800)");
		Thread.sleep(1000);
	}

	public void scrollDown32() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
	}

	public void scrollUp32() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-150)");
		Thread.sleep(1000);
	}

//----------------------------METHODS FOR SORT BY (SCENARIO 5)------------------------
	
	public void BusSection4() {
		busMenu.click();
	}

	public void Source4(String string) throws InterruptedException, AWTException {
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

	public void Destination4(String destination) throws InterruptedException, AWTException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toCity));
		toCity.sendKeys(destination);

		Robot ri = new Robot();

		ri.keyPress(KeyEvent.VK_DOWN);
		ri.keyRelease(KeyEvent.VK_DOWN);
		
		ri.delay(1000);
		
		ri.keyPress(KeyEvent.VK_ENTER);
		ri.keyRelease(KeyEvent.VK_ENTER);
		
		ri.delay(1000);

	}

	public void Date4() throws InterruptedException {
		WebElement selectDate = driver.findElement(By.xpath("//div[@aria-label=\"Fri May 24 2024\"]"));
		selectDate.click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(search));
		

	}

	public void scrollDown4() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	
	}

	public void Search4() {
		search.click();
	}
	
	public void clickFastestOption()
	{  
		fastest.click();
	}
	public void clickCheapestOption()
	{
		cheapest.click();
	}



}
