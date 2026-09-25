package org.example.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaCarrito;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TerminarCompra implements Interaction {

    public TerminarCompra() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaCarrito.BOTON_FINALIZAR_COMPRA, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(PaginaCarrito.BOTON_FINALIZAR_COMPRA),
                WaitUntil.the(PaginaCarrito.BOTON_CONTINUAR, isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(PaginaCarrito.BOTON_CONTINUAR, isEnabled()).forNoMoreThan(15).seconds(),
                Click.on(PaginaCarrito.BOTON_CONTINUAR)
        );
    }

    public static Performable finalizar() {
        return Tasks.instrumented(TerminarCompra.class);
    }
}
