package com.actitime.qa.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "F:\\UCSC\\Year 4\\IS 4102 - Advanced Software Quality Assurance\\Assignment 2\\Assignment New\\19020546_IS4102_Assignment2\\Section 3\\src\\main\\java\\com\\actitime\\qa\\feature"
		,glue={"com/actitime/qa/stepdefinitions"}
		,monochrome = true,
				strict=true,
				dryRun=false
				
		)




public class TestRunner {
	
	
	

}
