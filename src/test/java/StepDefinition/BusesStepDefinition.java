package StepDefinition;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import MMTDriverSetup.BusSetupDriver;
import Pages.BusesPageFactory;
import Pages.Filter1PageFactory;
import Pages.Filter2PageFactory;
import Pages.InvalidSearchPageFactory;
import Pages.SortByPageFactory;
import Pages.ValidSearchPageFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
//import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusesStepDefinition {
	static WebDriver driver;
	BusesPageFactory bf;

	@Given("User is on homepage")
	public void user_is_on_homepage() {
		driver = BusSetupDriver.chromeDriver();
		bf = new BusesPageFactory(driver);
		bf.BusSection();
	}

	@When("User enters the {string} Source")
	public void user_enters_the_source(String string) throws InterruptedException, AWTException {

		bf.Source(string);
	}

	@And("User enters the {string} destination")
	public void user_enters_the_destination(String string) throws InterruptedException, AWTException {
		bf.Destination(string);
	}

	@And("User enters the {string} of travel")
	public void user_enters_the_of_travel(String string) throws InterruptedException {
		bf.scrollDown();
		bf.Date();
	}

	@And("click on search")
	public void click_on_search() {
		bf.Search();
	}

	@Then("buses from source to destination should be displayed")
	public void buses_from_source_to_destination_should_be_displayed() {
		String str = "https://www.makemytrip.com/bus/search/Mumbai/Bangalore/24-05-2024?from_code=MMTCC1599&to_code=MMTCC1092";
		Assert.assertEquals(driver.getCurrentUrl(), str);

	}

	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	/*
	 * Created by: Shruti Shrivastava 
	 * Reviewed by: Akasha KC
	 * Motive: To ensure that the user can accurately select the source, destination, and date for booking a bus journey ticket, enabling a 
	 * smooth booking process without errors or confusion.
	 */
	/*--------------------------------------------------------------------------------------------------------------------------------------*/

	@When("User enters the From value")
	public void user_enters_the_from_value(DataTable src) throws InterruptedException, AWTException {
		List<List<String>> cell = src.cells();
		bf.Source1(cell.get(0).get(0));
	}

	@When("User enters the To value")
	public void user_enters_the_to_value(DataTable dest) throws InterruptedException, AWTException {
		List<List<String>> cell = dest.cells();
		bf.Destination1(cell.get(0).get(0));
	}

	@Then("error message should be displayed")
	public void error_message_should_be_displayed() {
		WebElement msg = driver.findElement(By.id("errorMessage"));
		String str1 = msg.getText();
		String str2 = "The Departure City and Destination City cannot be same. Please re-type.";
		Assert.assertEquals(str1, str2);
	}

	@AfterStep

	public static void takeScreendown(Scenario scenerio) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenerio.attach(src, "image/png", scenerio.getName());
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	/*
	 * Created by: Shruti Shrivastava 
	 * Reviewed by: Akasha KC
	 * Motive: To prevent users from entering the same location for both the source and destination, ensuring that bus tickets are booked for actual 
	 * journeys and avoiding potential errors in the booking process.
	 */
	/*--------------------------------------------------------------------------------------------------------------------------------------*/

	@When("User selects on non-AC button")
	public void user_selects_on_non_ac_button() throws InterruptedException, AWTException {
		bf.BusSection2();
		bf.Source2("Mumbai");
		bf.Destination2("Pune");
		bf.scrollDown2();
		bf.Date2();
		bf.Search2();
		bf.selectNonAC();
	}

	@When("User selects on sleeper button")
	public void user_selects_on_sleeper_button() {
		bf.selectSleeper();
	}

	@When("User clicks on single seater option")
	public void user_clicks_on_single_seater_option() {
		bf.clickOnSingleSeater();
	}

	@Then("list of buses which provides non-AC, sleeper and single seater services will be displayed")
	public void list_of_buses_which_provides_non_ac_sleeper_and_single_seater_services_will_be_displayed() {
		String msg = bf.getMessage2();
		Assert.assertTrue(msg.contains("17 buses found"));
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	/*
	 * Created by: Shruti Shrivastava 
	 * Reviewed by: Akasha KC
	 * Motive: To provide users with the ability to personalize their bus search by filtering options based on their comfort preferences, such as AC 
	 * preference, seat type, and the availability of single seats,enhancing their overall travel experience.
	 */
	/*--------------------------------------------------------------------------------------------------------------------------------------*/

	@When("User selects pickup point")
	public void user_selects_pickup_point(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException, AWTException {
		bf.BusSection3();
		bf.Source3("Mumbai");
		bf.Destination3("Pune");
		bf.scrollDown30();
		bf.Date3();
		bf.Search3();
		bf.scrollDown31();
		bf.selectPickUpPoint("Kharghar");
		bf.scrollDown32();
	}

	@And("User selects drop point")
	public void user_selects_drop_point(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		bf.selectDropPoint("Hinje Wadi");
		bf.scrollUp32();

	}

	@And("User selects travel operators")
	public void user_selects_travel_operators(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		bf.selectTravelOperator("VRL Travels");
		bf.scrollUp31();
	}

	@Then("list of buses which satisfies specific pickup point, drop point and travel operators will be displayed")
	public void list_of_buses_which_satisfies_specific_pickup_point_drop_point_and_travel_operators_will_be_displayed() {
		System.out.println("Scenerio 4 started");
		String msg = bf.getMessage3();
		Assert.assertTrue(msg.contains("25 buses found"));
		System.out.println("Scenerio 4 executed");
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	/*
	 * Created by: Shruti Shrivastava 
	 * Reviewed by: Akasha KC
	 * Motive:  To empower users with the capability to filter bus options based on specific preferences related to pickup points, travel 
	 * operators, and drop points, facilitating a more convenient and tailored journey planning experience.
	 */
	/*--------------------------------------------------------------------------------------------------------------------------------------*/

	@When("User clicks on fastest option")
	public void user_clicks_on_fastest_option() throws InterruptedException, AWTException {
		bf.BusSection4();
		bf.Source4("Delhi");
		bf.Destination4("Noida");
		bf.scrollDown4();
		bf.Date4();
		bf.Search4();
		bf.clickFastestOption();
	}

	@And("User clicks on cheapest option")
	public void user_clicks_on_cheapest_option() {
		bf.clickCheapestOption();
	}

	@Then("list of buses in the order of fastest and cheapest bus first will be displayed")
	public void list_of_buses_in_the_order_of_fastest_and_cheapest_bus_first_will_be_displayed() {
		Assert.assertTrue(false);
	}

	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	/*
	 * Created by: Shruti Shrivastava 
	 * Reviewed by: Akasha KC
	 * Motive:  To enable users to efficiently sort the list of available bus options based on their travel priorities, such as selecting the fastest or 
	 * cheapest bus first, allowing them to make informed decisions that align with their travel requirements and preferences.
	 * 
	 */
	/*--------------------------------------------------------------------------------------------------------------------------------------*/
}
