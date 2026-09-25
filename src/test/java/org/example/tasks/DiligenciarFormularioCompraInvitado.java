package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.model.DatosCompraInvitado;
import org.example.ui.PaginaCheckout;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DiligenciarFormularioCompraInvitado implements Task {

    private final DatosCompraInvitado datos;

    private DiligenciarFormularioCompraInvitado(DatosCompraInvitado datos) {
        this.datos = datos;
    }

    public static DiligenciarFormularioCompraInvitado conLosDatos(DatosCompraInvitado datos) {
        return new DiligenciarFormularioCompraInvitado(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaCheckout.CAMPO_NOMBRES, isVisible())
                        .forNoMoreThan(15).seconds(),
                Enter.theValue(datos.documento()).into(PaginaCheckout.CAMPO_DOCUMENTO),
                Enter.theValue(datos.nombres()).into(PaginaCheckout.CAMPO_NOMBRES),
                Enter.theValue(datos.apellidos()).into(PaginaCheckout.CAMPO_APELLIDOS),
                Enter.theValue(datos.correo()).into(PaginaCheckout.CAMPO_CORREO),
                Enter.theValue(datos.telefono()).into(PaginaCheckout.CAMPO_TELEFONO),
                Enter.theValue(datos.direccion()).into(PaginaCheckout.CAMPO_DIRECCION),
                SelectFromOptions.byVisibleText(datos.pais()).from(PaginaCheckout.SELECTOR_PAIS),
                SelectFromOptions.byVisibleText(datos.departamento()).from(PaginaCheckout.SELECTOR_DEPARTAMENTO),
                SelectFromOptions.byVisibleText(datos.ciudad()).from(PaginaCheckout.CAMPO_CIUDAD),
                Enter.theValue(datos.codigoPostal()).into(PaginaCheckout.CAMPO_CODIGO_POSTAL)
        );
    }
}
