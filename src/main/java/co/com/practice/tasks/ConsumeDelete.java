package co.com.practice.tasks;

import co.com.practice.interactions.ExecuteDelete;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;
import java.util.Map;

public class ConsumeDelete implements Task {
    private final String resource;

    private final List<Map<String, String>> id;

    public ConsumeDelete(String resource, List<Map<String, String>> id) {
        this.resource = resource;
        this.id = id;
    }

    public static ConsumeDelete service(String resource, List<Map<String, String>> id) {
        return Tasks.instrumented(ConsumeDelete.class, resource, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteDelete.service(resource, id));
    }
}
