package com.qa.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:/Users/A715914/eclipse-workspace/CucumberBDD/src/main/java/com/qa/Features/login.feature",
		glue = {"C:\\Users\\A715914\\eclipse-workspace\\CucumberBDD\\src\\main\\java\\com\\qa\\StepDef\\"},
		dryRun = false)

public class TestRunner {
	
	

}
