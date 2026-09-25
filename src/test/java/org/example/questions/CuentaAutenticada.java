package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaMiCuenta;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CuentaAutenticada implements Question<Boolean> {

    private final int tiempoDeEspera;

    private CuentaAutenticada(int tiempoDeEspera) {
        this.tiempoDeEspera = tiempoDeEspera;
    }

    public static CuentaAutenticada enLaCuenta() {
        return new CuentaAutenticada(10);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaMiCuenta.TITULO_HOME, isVisible()).forNoMoreThan(tiempoDeEspera).seconds()
        );
        return Visibility.of(PaginaMiCuenta.TITULO_HOME).answeredBy(actor);
    }
}