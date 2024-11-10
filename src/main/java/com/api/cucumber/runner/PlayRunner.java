package com.api.cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/main/java/com/api/cucumber/featurefile/PlayFeature.feature"},
        glue={"com.api.cucumber.stepdfn", "com.api.cucumber.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}  // Options pour les rapports
)

public class PlayRunner {
}
