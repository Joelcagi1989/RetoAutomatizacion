package co.com.practice.stepdefinitions;

import co.com.practice.exceptions.AssertionsServices;
import co.com.practice.models.TestData;
import co.com.practice.questions.TheFirstNameValuePostCreateBookingResponseIs;
import co.com.practice.tasks.ConsumePost;
import co.com.practice.tasks.Create;
import co.com.practice.utils.resource.BookingServiceEndPoint;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostCreateBookingStepdefinitions {

    @When("Call Post create booking")
    public void callPostCreateBooking() {
        theActorInTheSpotlight().attemptsTo(
                Create.messageBody("createbooking.json", TestData.getData())
        );
        theActorInTheSpotlight().attemptsTo(
                ConsumePost.service(BookingServiceEndPoint.URI.getUrl())
        );
    }

    @Then("Validate post response contain data firstname")
    public void validatePostResponseContainDataFirstName() {
        theActorInTheSpotlight()
                .should(seeThat(TheFirstNameValuePostCreateBookingResponseIs.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_AND_VALUES_POST_SERVICE_IS_NOT_EXPECTED)
                );
    }

}