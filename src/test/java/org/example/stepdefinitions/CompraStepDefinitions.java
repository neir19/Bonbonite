package org.example.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.example.interactions.ConfirmarPedidoComoInvitado;
import org.example.interactions.SeleccionarCompraComoInvitado;
import org.example.interactions.TerminarCompra;
import org.example.model.DatosContactoCompra;
import org.example.model.DatosCompraInvitado;
import org.example.model.DatosLogin;
import org.example.questions.ProductoEnCheckout;
import org.example.questions.TotalPedidoCoincideConProducto;
import org.example.tasks.DiligenciarFormularioCompraInvitado;
import org.example.tasks.DiligenciarDatosContactoCompra;
import org.example.tasks.IngresarALaCategoria;
import org.example.tasks.IniciarSesionEnCheckout;
import org.example.tasks.SeleccionarProductoAlAzar;
import org.example.tasks.SeleccionarTallaDisponible;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CompraStepDefinitions {



    @Cuando("el usuario ingresa a la categoría {string}")
    public void ingresarALaCategoria(String categoria) {
        theActorInTheSpotlight().attemptsTo(
                IngresarALaCategoria.llamada(categoria)
        );
    }

    @Y("selecciona un producto al azar de la categoría")
    public void seleccionarProductoAlAzar() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarProductoAlAzar.delCatalogo()
        );
    }

    @Y("selecciona una talla de las disponibles")
    public void seleccionarTallaDisponible() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarTallaDisponible.paraElProducto()
        );
    }

    @Y("realiza la venta del producto seleccionado")
    public void realizarLaVenta() {
        theActorInTheSpotlight().attemptsTo(
                TerminarCompra.finalizar()
        );
    }

    @Entonces("debe visualizar el producto en la pantalla de finalización de compra")
    public void validarProductoEnFinalizacionDeCompra() {
        theActorInTheSpotlight().should(
                seeThat(ProductoEnCheckout.esVisible())
        );
    }

    @Y("finaliza la compra como invitado")
    public void finalizaLaCompraComoInvitado() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarCompraComoInvitado.seleccionar()
        );
    }

    @Y("inicia sesión en el checkout con usuario {string} y contraseña {string}")
    public void iniciaSesionEnElCheckout(String usuario, String contrasena) {
        theActorInTheSpotlight().attemptsTo(
                IniciarSesionEnCheckout.conLosDatos(new DatosLogin(usuario, contrasena))
        );
    }

    @Y("diligencia el formulario de venta como invitado con los datos {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void diligenciaElFormularioComoInvitado(
            String documento,
            String nombres,
            String apellidos,
            String correo,
            String telefono,
            String direccion,
            String ciudad,
            String departamento,
            String pais,
            String codigoPostal
    ) {
        theActorInTheSpotlight().attemptsTo(
                DiligenciarFormularioCompraInvitado.conLosDatos(new DatosCompraInvitado(
                        documento,
                        nombres,
                        apellidos,
                        correo,
                        telefono,
                        direccion,
                        ciudad,
                        departamento,
                        pais,
                        codigoPostal
                ))
        );
    }

    @Y("diligencia el formulario de venta como invitado con los datos {string}, {string}, {string}, {string}, {string}, {string}")
    public void diligenciaLosDatosDeContacto(
            String telefono,
            String direccion,
            String ciudad,
            String departamento,
            String pais,
            String codigoPostal
    ) {
        theActorInTheSpotlight().attemptsTo(
                DiligenciarDatosContactoCompra.conLosDatos(new DatosContactoCompra(
                        telefono,
                        direccion,
                        ciudad,
                        departamento,
                        pais,
                        codigoPostal
                ))
        );
    }

    @Y("autoriza el tratamiento de datos y realiza el pedido")
    public void autorizaElTratamientoDeDatosYRealizaElPedido() {
        theActorInTheSpotlight().attemptsTo(
                ConfirmarPedidoComoInvitado.confirmar()
        );
    }

    @Entonces("el total del pedido debe ser igual al precio del producto comprado")
    public void validaTotalDelPedido() {
        theActorInTheSpotlight().should(
                seeThat(TotalPedidoCoincideConProducto.esIgualAlPrecioDelProducto())
        );
    }
}
