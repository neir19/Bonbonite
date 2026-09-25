package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaMiCuenta;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarRegistro implements Task {

    public static SeleccionarRegistro enLaCuenta() {
        return new SeleccionarRegistro();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaMiCuenta.OPCION_REGISTRATE, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PaginaMiCuenta.OPCION_REGISTRATE)
        );
    }
}
