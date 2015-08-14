package de.blogspot.mszalbach.chat.steps.page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.blogspot.mszalbach.chat.selenium.SeleniumDriver;
import de.blogspot.mszalbach.chat.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by foobar on 14.08.15.
 */
public class WebChat {

    private SeleniumDriver selenium ;


    public WebChat() {
        selenium = new SeleniumDriver();
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
        selenium.loadPage("http://" + Config.getApplicationURL() + "/" + Config.getApplicationContext() + "/index.html");
    }

}

