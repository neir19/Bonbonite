package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaMiCuenta;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DatosCuentaActualizados implements Question<Boolean> {

    public static DatosCuentaActualizados correctamente() {
        return new DatosCuentaActualizados();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaMiCuenta.MENSAJE_DATOS_CUENTA_ACTUALIZADOS, isVisible())
                        .forNoMoreThan(10).seconds()
        );
        return Visibility.of(PaginaMiCuenta.MENSAJE_DATOS_CUENTA_ACTUALIZADOS).answeredBy(actor);
    }
}
