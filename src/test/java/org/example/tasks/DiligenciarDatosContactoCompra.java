package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.model.DatosContactoCompra;
import org.example.ui.PaginaCheckout;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DiligenciarDatosContactoCompra implements Task {

    private final DatosContactoCompra datos;

    private DiligenciarDatosContactoCompra(DatosContactoCompra datos) {
        this.datos = datos;
    }

    public static DiligenciarDatosContactoCompra conLosDatos(DatosContactoCompra datos) {
        return new DiligenciarDatosContactoCompra(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaCheckout.CAMPO_TELEFONO, isVisible())
                        .forNoMoreThan(15).seconds(),
                Enter.theValue(datos.telefono()).into(PaginaCheckout.CAMPO_TELEFONO),
                Enter.theValue(datos.direccion()).into(PaginaCheckout.CAMPO_DIRECCION),
                SelectFromOptions.byVisibleText(datos.pais()).from(PaginaCheckout.SELECTOR_PAIS),
                SelectFromOptions.byVisibleText(datos.departamento()).from(PaginaCheckout.SELECTOR_DEPARTAMENTO),
                SelectFromOptions.byVisibleText(datos.ciudad()).from(PaginaCheckout.CAMPO_CIUDAD),
                Enter.theValue(datos.codigoPostal()).into(PaginaCheckout.CAMPO_CODIGO_POSTAL)
        );
    }
}
