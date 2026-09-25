package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaMiCuenta;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ErrorInicioSesion implements Question<Boolean> {

    public static ErrorInicioSesion esVisible() {
        return new ErrorInicioSesion();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaMiCuenta.MENSAJE_ERROR_LOGIN, isVisible())
                        .forNoMoreThan(10).seconds()
        );
        return Visibility.of(PaginaMiCuenta.MENSAJE_ERROR_LOGIN).answeredBy(actor);
    }
}
