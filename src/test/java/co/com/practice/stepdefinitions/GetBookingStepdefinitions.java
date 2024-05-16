package co.com.practice.stepdefinitions;

import co.com.practice.exceptions.AssertionsServices;
import co.com.practice.questions.*;
import co.com.practice.tasks.ConsumeGet;
import co.com.practice.tasks.Load;
import co.com.practice.utils.resource.BookingServiceEndPoint;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetBookingStepdefinitions {

    @When("Call Get booking")
    public void callGetBooking() {
        theActorInTheSpotlight().attemptsTo(
                ConsumeGet.service(
                        BookingServiceEndPoint.URI.getUrl()
                ));
    }

    @Then("Validate booking get response contain data expected")
    public void validateBookingGetResponseContainDataExpected(List<Map<String, String>> dataValidation) {
        theActorInTheSpotlight().wasAbleTo(
                Load.testData(dataValidation.get(0))
        );
        theActorInTheSpotlight()
                .should(seeThat(TheFirstNameValueGetBookingResponseIs.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_SERVICE_IS_NOT_EXPECTED)
                );
    }
}