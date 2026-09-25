package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.model.DatosLogin;
import org.example.ui.PaginaMiCuenta;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DiligenciarCamposDeInicioDeSesion implements Task {

    private final DatosLogin credenciales;

    private DiligenciarCamposDeInicioDeSesion(DatosLogin credenciales) {
        this.credenciales = credenciales;
    }

    public static DiligenciarCamposDeInicioDeSesion conLosDatos(DatosLogin credenciales) {
        return new DiligenciarCamposDeInicioDeSesion(credenciales);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaMiCuenta.CAMPO_USUARIO_LOGIN, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(credenciales.cedula()).into(PaginaMiCuenta.CAMPO_USUARIO_LOGIN),
                Enter.theValue(credenciales.contrasena()).into(PaginaMiCuenta.CAMPO_CONTRASENA_LOGIN)
        );
    }
}
