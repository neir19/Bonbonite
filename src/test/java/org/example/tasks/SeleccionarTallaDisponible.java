package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.interactions.SeleccionarElementoAlAzar;
import org.example.ui.PaginaProducto;


import java.time.Duration;

import java.util.Random;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarTallaDisponible implements Task {

    private static final Random RANDOM = new Random();
    public static SeleccionarTallaDisponible paraElProducto() {
        return new SeleccionarTallaDisponible();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                WaitUntil.the(PaginaProducto.TITULO_PRODUCTO, isVisible()).forNoMoreThan(10).seconds()
        );

        BrowseTheWeb.as(actor)
                .getDriver()
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(4));


    if(PaginaProducto.BOTON_COMPRAR_AHORA_DESHABILITADO.resolveFor(actor).isVisible()){
            actor.attemptsTo(
                    SeleccionarElementoAlAzar.seleccionar(PaginaProducto.TALLAS_DISPONIBLES),
                    Click.on(PaginaProducto.BOTON_COMPRAR_AHORA));

        } else {
            actor.attemptsTo(
                    Click.on(PaginaProducto.BOTON_COMPRAR_AHORA)
            );

        }
    }
}
