package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.model.DatosRegistro;
import org.example.ui.PaginaMiCuenta;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DiligenciarFormularioDeRegistro implements Task {

    private final DatosRegistro datos;

    private DiligenciarFormularioDeRegistro(DatosRegistro datos) {
        this.datos = datos;
    }

    public static DiligenciarFormularioDeRegistro conLosDatos(DatosRegistro datos) {
        return new DiligenciarFormularioDeRegistro(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaMiCuenta.CAMPO_CEDULA, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(datos.cedula()).into(PaginaMiCuenta.CAMPO_CEDULA),
                Enter.theValue(datos.nombres()).into(PaginaMiCuenta.CAMPO_NOMBRES),
                Enter.theValue(datos.apellidos()).into(PaginaMiCuenta.CAMPO_APELLIDOS),
                Enter.theValue(datos.correo()).into(PaginaMiCuenta.CAMPO_CORREO),
                Enter.theValue(datos.contrasena()).into(PaginaMiCuenta.CAMPO_CONTRASENA),
                Enter.theValue(datos.contrasena()).into(PaginaMiCuenta.CAMPO_CONFIRMACION_CONTRASENA)
        );
    }
}
