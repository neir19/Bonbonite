package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.model.DatosCuenta;
import org.example.ui.PaginaMiCuenta;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DiligenciarDatosDeCuenta implements Task {

    private final DatosCuenta datos;

    private DiligenciarDatosDeCuenta(DatosCuenta datos) {
        this.datos = datos;
    }

    public static DiligenciarDatosDeCuenta conLosDatos(DatosCuenta datos) {
        return new DiligenciarDatosDeCuenta(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaMiCuenta.CAMPO_NOMBRES_CUENTA_ACTUALIZAR, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(datos.nombres()).into(PaginaMiCuenta.CAMPO_NOMBRES_CUENTA_ACTUALIZAR),
                Enter.theValue(datos.apellidos()).into(PaginaMiCuenta.CAMPO_APELLIDOS_CUENTA_ACTUALIZAR),
                Enter.theValue(datos.correo()).into(PaginaMiCuenta.CAMPO_CORREO_CUENTA_ACTUALIZAR)
        );
    }
}
