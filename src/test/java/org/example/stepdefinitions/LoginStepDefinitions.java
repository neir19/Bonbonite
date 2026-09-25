package org.example.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.example.model.DatosCuenta;
import org.example.model.DatosLogin;

import org.example.questions.CuentaAutenticada;
import org.example.questions.DatosCuentaActualizados;
import org.example.questions.ErrorInicioSesion;
import org.example.tasks.DiligenciarDatosDeCuenta;
import org.example.tasks.DiligenciarCamposDeInicioDeSesion;
import org.example.tasks.EnviarFormularioDeInicioDeSesion;
import org.example.tasks.GuardarCambiosDeCuenta;
import org.example.tasks.SeleccionarDetallesDeCuenta;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinitions {

    @Y("diligencia los campos del inicio de sesión con los siguientes datos:")
    public void diligenciarLosCamposDelInicioDeSesion(DataTable credenciales) {
        Map<String, String> datos = credenciales.asMaps(String.class, String.class).get(0);
        theActorInTheSpotlight().attemptsTo(
                DiligenciarCamposDeInicioDeSesion.conLosDatos(DatosLogin.desde(datos))
        );
    }

    @Y("selecciona el botón \"Iniciar Sesión\"")
    public void seleccionarIniciarSesion() {
        theActorInTheSpotlight().attemptsTo(
                EnviarFormularioDeInicioDeSesion.enviar()
        );
    }

    @Entonces("el sistema debe autenticar al usuario exitosamente")
    public void validarAutenticacionExitosa() {
        theActorInTheSpotlight().should(
                seeThat(CuentaAutenticada.enLaCuenta())
        );
    }

    @Entonces("debe visualizar un mensaje de error de inicio de sesión")
    public void validarErrorDeInicioSesion() {
        theActorInTheSpotlight().should(
                seeThat(ErrorInicioSesion.esVisible())
        );
    }

    @Y("selecciona la opción \"Detalles de la cuenta\"")
    public void seleccionarDetallesDeCuenta() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarDetallesDeCuenta.enLaCuenta()
        );
    }

    @Y("modifica sus datos con la siguiente información:")
    public void modificarDatosDeCuenta(DataTable datos) {
        Map<String, String> fila = datos.asMaps(String.class, String.class).get(0);
        theActorInTheSpotlight().attemptsTo(
                DiligenciarDatosDeCuenta.conLosDatos(DatosCuenta.desde(fila))
        );
    }

    @Y("guarda los cambios de sus datos")
    public void guardarCambiosDeCuenta() {
        theActorInTheSpotlight().attemptsTo(
                GuardarCambiosDeCuenta.guardar()
        );
    }

    @Entonces("debe visualizar la confirmación de actualización de sus datos")
    public void validarActualizacionDeDatos() {
        theActorInTheSpotlight().should(
                seeThat(DatosCuentaActualizados.correctamente())
        );
    }
}