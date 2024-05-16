package co.com.practice.interactions;

import co.com.practice.exceptions.ErrorServicesException;
import co.com.practice.models.TestData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import org.apache.http.HttpStatus;

import java.util.List;
import java.util.Map;

import static co.com.practice.utils.constants.Constants.EXCEPTION_ERROR_CONSUMPTION_SERVICE;
import static io.restassured.http.ContentType.JSON;

public class ExecuteDelete implements Interaction {
    private final String resource;
    private final List<Map<String, String>> id;

    public ExecuteDelete(String resource, List<Map<String, String>> id) {
        this.resource = resource;
        this.id = id;
    }

    public static ExecuteDelete service(String resource, List<Map<String, String>> id) {
        return Tasks.instrumented(ExecuteDelete.class, resource, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Delete.from(resource+"/"+id.get(0).get("id"))
                        .with(request -> request.
                                contentType(JSON)
                                .cookie("token", id.get(0).get("token"))
                                .relaxedHTTPSValidation().log().all()
                        )
        );

        if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_CREATED){
            throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
        }
    }
}