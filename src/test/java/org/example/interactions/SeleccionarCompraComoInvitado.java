package org.example.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaCheckout;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarCompraComoInvitado implements Interaction {

    public static Performable seleccionar() {
        return Tasks.instrumented(SeleccionarCompraComoInvitado.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaCheckout.OPCION_COMPRAR_COMO_INVITADO, isVisible())
                        .forNoMoreThan(15).seconds(),
                WaitUntil.the(PaginaCheckout.OPCION_COMPRAR_COMO_INVITADO, isEnabled())
                        .forNoMoreThan(15).seconds(),
                Click.on(PaginaCheckout.OPCION_COMPRAR_COMO_INVITADO)
        );
    }
}
