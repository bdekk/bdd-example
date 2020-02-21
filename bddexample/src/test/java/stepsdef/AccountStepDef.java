package stepsdef;

import account.API;
import account.Account;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class AccountStepDef {

    private AccountBuilder accountBuilder;
    private Response response;

    @Given("a user with valid credentials")
    public void aUserWithValidCredentials() {
        accountBuilder = new AccountBuilder();
        accountBuilder.withUsername("bram");
        accountBuilder.withPassword("test");
    }

    @Given("a user with invalid credentials")
    public void aUserWithInvalidCredentials() {
        accountBuilder = new AccountBuilder();
        accountBuilder.withUsername("Invalid");
        accountBuilder.withPassword("Credentials");
    }

    @Given("a user")
    public void aUser() {
        accountBuilder = new AccountBuilder();
    }

    @Given("user has username {string}")
    public void userHasUsername(String username) {
        accountBuilder.withUsername(username);
    }

    @Given("user has password {string}")
    public void userHasPassword(String password) {
        accountBuilder.withPassword(password);
    }

    @When("the user logs in")
    public void theUserLogsIn() {
        Account validAccount = accountBuilder.create();
        response = given()
        .contentType("application/json")
        .body(validAccount).post(API.URL + API.LOGIN_ROUTE);
    }

    @Then("the user should not be logged in")
    public void theUserShouldNotBeLoggedIn() {
        Assert.assertEquals(403, response.statusCode());
    }

    @Then("the user should be logged in")
    public void theUserShouldBeLoggedIn() {
        Assert.assertEquals(200, response.statusCode());
    }
}
