package com.beniregev.springcucumberexampleapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import cucumber.api.java8.En;

/**
 * <p>
 * <div>
 *     What Is Gherkin?
 * </div>
 * <div>
 *     Gherkin is a simple set of grammar rules that make Plain Text structured enough
 *     for Cucumber to understand. The scenario above is written in Gherkin.
 * </div>
 * </p>
 * @author Binyamin Regev
 * @since 1.8
 */
public class BagCucmberStepDefinitions extends SpringCucumberIntegrationTests implements En {
    private final Logger log = LoggerFactory.getLogger(BagCucmberStepDefinitions.class);

    public BagCucmberStepDefinitions() {

        Given("the bag is empty", () -> {
            clean();
            assertThat(getContents().isEmpty()).isTrue();
        });

        When("I put {int} {word} in the bag", (Integer quantity, String something) -> {
            IntStream.range(0, quantity).peek(n -> log.info("Putting a {} in the bag, number {}", something, quantity))
                    .map(ignore -> put(something))
                    .forEach(statusCode -> assertThat(statusCode).isEqualTo(HttpStatus.CREATED.value()));
        });

        Then("the bag should contain only {int} {word}", (Integer quantity, String something) -> {
            assertNumberOfTimes(quantity, something, true);
        });

        Then("the bag should contain {int} {word}", (Integer quantity, String something) -> {
            assertNumberOfTimes(quantity, something, false);
        });

    }

    private void assertNumberOfTimes(final int quantity, final String something, final boolean onlyThat) {
        final List<String> things = getContents().getThings();
        log.info("Expecting {} times {}. The bag contains {}", quantity, something, things);
        final int timesInList = Collections.frequency(things, something);
        assertThat(timesInList).isEqualTo(quantity);
        if (onlyThat) {
            assertThat(timesInList).isEqualTo(things.size());
        }
    }
}