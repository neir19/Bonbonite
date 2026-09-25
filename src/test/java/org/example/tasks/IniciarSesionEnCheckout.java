package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.model.DatosLogin;
import org.example.ui.PaginaCheckout;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IniciarSesionEnCheckout implements Task {

    private final DatosLogin credenciales;

    private IniciarSesionEnCheckout(DatosLogin credenciales) {
        this.credenciales = credenciales;
    }

    public static IniciarSesionEnCheckout conLosDatos(DatosLogin credenciales) {
        return new IniciarSesionEnCheckout(credenciales);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaCheckout.CAMPO_USUARIO, isVisible())
                        .forNoMoreThan(15).seconds(),
                Enter.theValue(credenciales.cedula()).into(PaginaCheckout.CAMPO_USUARIO),
                Enter.theValue(credenciales.contrasena()).into(PaginaCheckout.CAMPO_CONTRASENA),
                WaitUntil.the(PaginaCheckout.BOTON_INICIAR_SESION, isEnabled())
                        .forNoMoreThan(15).seconds(),
                Click.on(PaginaCheckout.BOTON_INICIAR_SESION)
        );
    }
}
