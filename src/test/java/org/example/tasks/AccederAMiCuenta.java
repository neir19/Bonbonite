package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.actions.EnterValueIntoBy;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.example.ui.PaginaMiCuenta;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AccederAMiCuenta implements Task {

    public static AccederAMiCuenta desdeElEncabezado() {
        return new AccederAMiCuenta();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaMiCuenta.OPCION_MI_CUENTA, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PaginaMiCuenta.OPCION_MI_CUENTA)
        );
    }
}