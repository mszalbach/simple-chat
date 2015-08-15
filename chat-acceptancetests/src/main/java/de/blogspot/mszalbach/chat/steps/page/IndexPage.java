package de.blogspot.mszalbach.chat.steps.page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import de.blogspot.mszalbach.chat.selenium.SeleniumDriver;
import org.openqa.selenium.By;

import javax.inject.Inject;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by foobar on 14.08.15.
 */
@ScenarioScoped
public class IndexPage {

    private SeleniumDriver selenium ;


    @Inject
    public IndexPage(SeleniumDriver selenium) {
        this.selenium = selenium;
    }


    @Given("I visit the chat website")
    public void visitIndex() {
        openIndex();
    }

    @When("I change my nickname to \"(.+)\"$")
    public void changeNickname(String name ) {
        selenium.typeIntoField("name", name);
    }

    @When("I send message \"(.+)\"$")
    public void sendMessage(String message) throws IOException {
        selenium.typeIntoField("message", message);
        submitForm();
    }

    @Then("^webchat contains message \"(.+)\"$")
    public void expectMessage(String message) {
        String text = selenium.getDriver().findElement(By.id("messages")).getAttribute("value");
        assertThat(text.contains(message), is(true));

    }

    private void submitForm() {
        selenium.getDriver().findElement(By.id("sendButton")).click();
    }

    private void openIndex() {
        selenium.loadPage("index.html");
    }

}

