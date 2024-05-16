package co.com.practice.interactions;

import co.com.practice.exceptions.ErrorServicesException;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.apache.http.HttpStatus;

import java.util.List;
import java.util.Map;

import static co.com.practice.utils.constants.Constants.EXCEPTION_ERROR_CONSUMPTION_SERVICE;
import static io.restassured.http.ContentType.JSON;

public class ExecutePut implements Interaction {
    private final String resource;
    private final String body;
    private final List<Map<String, String>> id;

    public ExecutePut(String resource, String body, List<Map<String, String>> id) {
        this.resource = resource;
        this.body = body;
        this.id = id;
    }

    public static ExecutePut service(String resource, String body, List<Map<String, String>> id) {
        return Tasks.instrumented(ExecutePut.class, resource, body, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Put.to(resource+"/"+id.get(0).get("id"))
                        .with(request -> request
                                .contentType(JSON)
                                .cookie("token", id.get(0).get("token"))
                                .body(body)
                                .relaxedHTTPSValidation().log().all()
                        )
        );

        if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
            throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
        }
    }
}
