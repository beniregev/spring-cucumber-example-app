package com.beniregev.springcucumberexampleapp;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Cucumber Launcher
 * The {@code @CucumberOptions} annotation is responsible for two tasks here:
 *  +   pointing right file feature file and configuring the plugin for better reporting
 *      of tests both in the console output and as HTML.
 *  +   The second part (plugin) is optional.
 * Valid values for {@code plugin} format:
 *  +   Pretty      Like I used in this example, will display the test result in a pretty plain text.
 *  +   Html        You can specify the target where the {@code HTML} file will be stored. In this
 *                  example "target/cucumber". After running "mvn clean test" look for {@code index.html}
 *                  file in {@code target/cucumber} folder.
 *  +   Json        Results are stored in a JSON file ready to be read or sent to another application.
 * @author Binyamin Regev
 * @since 1.8
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/bag.feature",
        plugin = {"pretty", "html:target/cucumber"})
public class BagCucmberIntegrationTest {

}
