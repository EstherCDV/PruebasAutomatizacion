package com.selenium;

//junit 5
//import org.junit.platform.suite.api.IncludeEngines;
//import org.junit.platform.suite.api.Suite;
//import org.junit.platform.suite.api.SelectClasspathResource;

//junit 4
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.selenium"}
)
public class TestRunner {
}