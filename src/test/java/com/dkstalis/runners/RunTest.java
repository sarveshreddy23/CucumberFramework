package com.dkstalis.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src//test//resource//features",
        plugin = {"pretty","json:target/cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml", "html:target/cucumber-reports"},
        glue={"com.dkstalis.steps"},
        strict = false,
        dryRun = false,
        monochrome = true
)


public class RunTest {
}
