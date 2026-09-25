package org.example.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.Random;

public class SeleccionarElementoAlAzar implements Interaction {
    private final Target elemento;
    private static final Random RANDOM = new Random();

    public SeleccionarElementoAlAzar(Target elemento) {
        this.elemento = elemento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> elementos = elemento.resolveAllFor(actor);
        if (elementos.isEmpty()) {
            throw new IllegalStateException("No se encontraron elementos para seleccionar al azar");
        }

        WebElementFacade elementoSeleccionado = elementos.get(RANDOM.nextInt(elementos.size()));
        actor.attemptsTo(
                Scroll.to(elementoSeleccionado),
                Click.on(elementoSeleccionado)
        );

    }

    public static Performable seleccionar(Target elemento) {
        return new SeleccionarElementoAlAzar(elemento);
    }
}
