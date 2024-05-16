package co.com.practice.stepdefinitions;

import co.com.practice.models.TestData;
import co.com.practice.tasks.ConsumePost;
import co.com.practice.tasks.Create;
import co.com.practice.tasks.Load;
import co.com.practice.utils.resource.AuthServiceEndPoint;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostCreateTokenStepdefinitions {

    @Given("Load user credentials")
    public void loadUserCredentials(List<Map<String, String>> clientDetails) {
        theActorInTheSpotlight().wasAbleTo(
                Load.testData(clientDetails.get(0))
        );
    }

    @When("Call Post create token")
    public void callPostCreateToken() {
        theActorInTheSpotlight().attemptsTo(
                Create.messageBody("createtoken.json", TestData.getData())
        );
        theActorInTheSpotlight().attemptsTo(
                ConsumePost.service(AuthServiceEndPoint.URI.getUrl())
        );
    }

}