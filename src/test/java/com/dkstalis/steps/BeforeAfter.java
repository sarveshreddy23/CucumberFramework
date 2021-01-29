package com.dkstalis.steps;

import com.dkstalis.utills.SeleniumUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAfter {

    SeleniumUtils selenium = SeleniumUtils.getInstance();

    @Before
    public void beforeScenario(Scenario scenario){
        System.out.println(":::::Before Scenario:::::");
        SeleniumUtils.currentScenario = scenario;
    }

    @After
    public void afterScenario(){
        System.out.println(":::::After Scenario:::::");
        if(SeleniumUtils.currentScenario.isFailed()){
            SeleniumUtils.currentScenario.write(SeleniumUtils.currentScenario.getName());
            selenium.takeScreenshot();
        }
        selenium.quit();
    }

}
