package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaMiCuenta;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarDetallesDeCuenta implements Task {

    public static SeleccionarDetallesDeCuenta enLaCuenta() {
        return new SeleccionarDetallesDeCuenta();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaMiCuenta.OPCION_DETALLES_DE_CUENTA, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PaginaMiCuenta.OPCION_DETALLES_DE_CUENTA),
                WaitUntil.the(PaginaMiCuenta.BOTON_ACTUALIZAR_DATOS, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PaginaMiCuenta.BOTON_ACTUALIZAR_DATOS)
        );
    }
}
