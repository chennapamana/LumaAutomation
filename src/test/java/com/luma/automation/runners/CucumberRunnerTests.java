package com.luma.automation.runners;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/lumaRegisterPage.feature")   // Location of your feature files
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "com.luma.automation.stepDefinitions,com.luma.automation.hooks"
)
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}
