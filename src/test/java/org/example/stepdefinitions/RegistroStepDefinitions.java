package org.example.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.example.model.DatosRegistro;
import org.example.questions.CuentaAutenticada;
import org.example.questions.ErrorRegistro;
import org.example.tasks.AccederAMiCuenta;
import org.example.tasks.AceptarTratamientoDeDatos;
import org.example.tasks.DiligenciarFormularioDeRegistro;
import org.example.tasks.EnviarFormularioDeRegistro;
import org.example.tasks.NavegarAZapatosMujer;
import org.example.tasks.SeleccionarRegistro;
import org.example.utils.Constantes;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegistroStepDefinitions {

    @Dado("que el usuario se encuentra en la página de zapatos para mujer de Bon-Bonite")
    public void enLaPaginaDeZapatosParaMujer() {
        theActorCalled(Constantes.NOMBRE_ACTOR).wasAbleTo(
                NavegarAZapatosMujer.desdeElSitio()
        );
    }

    @Cuando("el usuario selecciona la opción \"Mi cuenta\"")
    public void seleccionarMiCuenta() {
        theActorInTheSpotlight().attemptsTo(
                AccederAMiCuenta.desdeElEncabezado()
        );
    }

    @Y("selecciona la opción \"Regístrate\"")
    public void seleccionarRegistrate() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarRegistro.enLaCuenta()
        );
    }

    @Y("diligencia los campos del registro con los siguientes datos:")
    public void diligenciarLosCamposDelRegistro(DataTable datos) {
        Map<String, String> fila = datos.asMaps(String.class, String.class).get(0);
        theActorInTheSpotlight().attemptsTo(
                DiligenciarFormularioDeRegistro.conLosDatos(DatosRegistro.desde(fila))
        );
    }

    @Y("acepta la autorización para el tratamiento de sus datos personales")
    public void aceptarLaAutorizacion() {
        theActorInTheSpotlight().attemptsTo(
                AceptarTratamientoDeDatos.personales()
        );
    }

    @Y("selecciona el botón \"Registrarme\"")
    public void seleccionarRegistrarme() {
        theActorInTheSpotlight().attemptsTo(
                EnviarFormularioDeRegistro.registrarse()
        );
    }

    @Entonces("debe visualizar la cuenta del usuario autenticado")
    public void validarCuentaAutenticada() {
        theActorInTheSpotlight().should(
                seeThat(CuentaAutenticada.enLaCuenta())
        );
    }

    @Entonces("debe visualizar un mensaje de error de registro")
    public void validarErrorDeRegistro() {
        theActorInTheSpotlight().should(
                seeThat(ErrorRegistro.esVisible())
        );
    }
}
