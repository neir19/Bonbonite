package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaCatalogo;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarALaCategoria implements Task {

    private final String categoria;

    private IngresarALaCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static IngresarALaCategoria llamada(String categoria) {
        return new IngresarALaCategoria(categoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaCatalogo.OPCION_CATEGORIA.of(categoria), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PaginaCatalogo.OPCION_CATEGORIA.of(categoria))
        );
    }
}
