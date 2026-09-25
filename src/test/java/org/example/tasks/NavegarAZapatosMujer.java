package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaZapatosMujer;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavegarAZapatosMujer implements Task {

    public static NavegarAZapatosMujer desdeElSitio() {
        return new NavegarAZapatosMujer();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().thePageNamed("pages.zapatosMujer"),
                WaitUntil.the(PaginaZapatosMujer.CABECERA, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}