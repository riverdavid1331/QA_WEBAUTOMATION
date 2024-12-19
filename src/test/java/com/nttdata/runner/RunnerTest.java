package com.nttdata.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports"},
        stepNotifications = true,
        features = "src/test/resources/features",
        glue = "com.nttdata.steps"//{"com.nttdata.steps", "com.nttdata.stepsdefinitions"} // Incluye los hooks aquí
        //tags = "@test"
)
public class RunnerTest {
}
