package co.com.practice.stepdefinitions;

import co.com.practice.exceptions.AssertionsServices;
import co.com.practice.models.TestData;
import co.com.practice.questions.TheFirstNameValuePutBookingResponseIs;
import co.com.practice.tasks.ConsumePut;
import co.com.practice.tasks.Create;
import co.com.practice.tasks.Load;
import co.com.practice.utils.resource.BookingServiceEndPoint;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PutUpdateBookingStepdefinitions {

    @When("Call Put update booking")
    public void callPutUpdateBooking(List<Map<String, String>> dataValidation) {
        theActorInTheSpotlight().attemptsTo(
                Create.messageBody("createbooking.json", TestData.getData())
        );
        theActorInTheSpotlight().attemptsTo(
                Load.testData(dataValidation.get(0)),
                ConsumePut.service(BookingServiceEndPoint.URI.getUrl(), dataValidation)
        );
    }

    @Then("Validate put update booking response contain data expected")
    public void validatePutUpdateBookingResponseContainDataExpected() {
        theActorInTheSpotlight()
                .should(seeThat(TheFirstNameValuePutBookingResponseIs.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_FIELDS_AND_VALUES_POST_SERVICE_IS_NOT_EXPECTED)
                );
    }
}