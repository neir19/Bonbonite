package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.interactions.SeleccionarElementoAlAzar;
import org.example.ui.PaginaCatalogo;
import org.example.ui.PaginaProducto;
import org.example.utils.Constantes;

import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.ui.PaginaProducto.ACEPTAR_TODO;

public class SeleccionarProductoAlAzar implements Task {

    private static final Random RANDOM = new Random();

    public static SeleccionarProductoAlAzar delCatalogo() {
        return new SeleccionarProductoAlAzar();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(PaginaCatalogo.PRODUCTOS, isVisible()).forNoMoreThan(15).seconds()


        );
        if (ACEPTAR_TODO.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(ACEPTAR_TODO)
            );
        }
        actor.attemptsTo(SeleccionarElementoAlAzar.seleccionar(PaginaCatalogo.PRODUCTOS));

    }
}
