package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.example.ui.PaginaMiCuenta;

public class AceptarTratamientoDeDatos implements Task {

    public static AceptarTratamientoDeDatos personales() {
        return new AceptarTratamientoDeDatos();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaMiCuenta.CASILLA_AUTORIZACION_DATOS)
        );
    }
}