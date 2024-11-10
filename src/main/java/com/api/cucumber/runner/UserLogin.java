package com.api.cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/main/java/com/api/cucumber/featurefile/LoginFeature.feature"},
        glue={"com.api.cucumber.stepdfn"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},  // Options pour les rapports
        dryRun = true,
        monochrome = true
)
public class UserLogin {
}
