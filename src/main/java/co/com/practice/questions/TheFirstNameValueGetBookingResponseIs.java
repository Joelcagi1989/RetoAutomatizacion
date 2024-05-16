package co.com.practice.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.practice.models.TestData.getData;
import static co.com.practice.utils.constants.Constants.VALIDATION_FIELDS_AND_VALUES;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class TheFirstNameValueGetBookingResponseIs implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse(String.format(VALIDATION_FIELDS_AND_VALUES, "list get"),
                        response -> response
                                .assertThat()
                                .body("firstname", equalTo(getData().get("firstname").toString()))
                ));
        return true;
    }

    public static TheFirstNameValueGetBookingResponseIs expected() {
        return new TheFirstNameValueGetBookingResponseIs();
    }
}
