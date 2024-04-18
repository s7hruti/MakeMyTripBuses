package MMTRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resource\\Features\\MMT_Bus.feature", glue = "StepDefinition",
//tags="@All"
//tags="@InvalidSearch"
//tags = "@SortBy"
//tags="@Filter1"
//tags="@Filter2"
tags="@Search"
//,
//plugin= {"pretty",
//		"html:target/HTMLReports/MMTBuses.html",	
//		"json:target/JSONReports/MMTBuses.json",
//		"junit:target/JUNITReports/MMTBuses.xml",		
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class BusesRunner extends AbstractTestNGCucumberTests {

}
