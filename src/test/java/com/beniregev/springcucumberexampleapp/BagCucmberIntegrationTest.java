package com.beniregev.springcucumberexampleapp;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Cucumber Launcher
 * Like plugin there's format:
 * Pretty
 * Html
 * Json
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/bag.feature",
        plugin = {"pretty", "html:target/cucumber"})
public class BagCucmberIntegrationTest {

}
