package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaCheckout;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProductoEnCheckout implements Question<Boolean> {

    public static ProductoEnCheckout esVisible() {
        return new ProductoEnCheckout();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaCheckout.FORMULARIO_CHECKOUT, isVisible()).forNoMoreThan(15).seconds()
        );
        return Visibility.of(PaginaCheckout.FORMULARIO_CHECKOUT).answeredBy(actor);
    }
}
