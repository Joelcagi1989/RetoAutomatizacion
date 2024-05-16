package co.com.practice.stepdefinitions;

import co.com.practice.models.TestData;
import co.com.practice.tasks.ConsumeDelete;
import co.com.practice.tasks.Load;
import co.com.practice.utils.resource.BookingServiceEndPoint;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteBookingStepdefinitions {

    @When("Call Delete booking")
    public void callDeleteBooking(List<Map<String, String>> dataValidation) {
        theActorInTheSpotlight().attemptsTo(
                Load.testData(dataValidation.get(0)),
                ConsumeDelete.service(
                        BookingServiceEndPoint.URI.getUrl(), dataValidation
                ));
    }
}