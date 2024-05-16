package co.com.practice.tasks;

import co.com.practice.interactions.ExecutePut;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;
import java.util.Map;

import static co.com.practice.utils.constants.Constants.BODY;

public class ConsumePut implements Task {
    private final String resource;
    private final List<Map<String, String>> id;

    public ConsumePut(String resource, List<Map<String, String>> id) {
        this.resource = resource;
        this.id = id;
    }

    public static ConsumePut service(String resource, List<Map<String, String>> id) {
        return Tasks.instrumented(ConsumePut.class, resource, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = actor.recall(BODY).toString();
        actor.attemptsTo(ExecutePut.service(resource, body, id));
    }
}
