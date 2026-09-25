package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.example.ui.PaginaMiCuenta;

public class EnviarFormularioDeInicioDeSesion implements Task {

    public static EnviarFormularioDeInicioDeSesion enviar() {
        return new EnviarFormularioDeInicioDeSesion();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaMiCuenta.BOTON_INICIAR_SESION)
        );
    }
}
