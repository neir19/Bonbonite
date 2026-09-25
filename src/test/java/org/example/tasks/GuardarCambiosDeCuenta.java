package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.example.ui.PaginaMiCuenta;

public class GuardarCambiosDeCuenta implements Task {

    public static GuardarCambiosDeCuenta guardar() {
        return new GuardarCambiosDeCuenta();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaMiCuenta.BOTON_GUARDAR_CAMBIOS_CUENTA_ACTUALIZAR)
        );
    }
}
