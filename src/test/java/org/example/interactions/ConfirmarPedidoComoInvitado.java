package org.example.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaCheckout;
import org.example.utils.ScrollAlInicio;
import org.openqa.selenium.StaleElementReferenceException;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

public class ConfirmarPedidoComoInvitado implements Interaction {

    private static final String PRECIO_PRODUCTO = "precioProductoCheckout";
    private static final String TOTAL_PEDIDO = "totalPedidoCheckout";

    public static Performable confirmar() {
        return Tasks.instrumented(ConfirmarPedidoComoInvitado.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaCheckout.PRECIO_PRODUCTO_EN_RESUMEN, isVisible())
                        .forNoMoreThan(15).seconds(),
                WaitUntil.the(PaginaCheckout.TOTAL_PEDIDO, isVisible())
                        .forNoMoreThan(15).seconds(),
                WaitUntil.the(PaginaCheckout.TOTAL_PEDIDO, containsText("$"))
                        .forNoMoreThan(15).seconds(),
                ScrollAlInicio.deLaPagina(),
                WaitUntil.the(PaginaCheckout.CASILLA_AUTORIZACION, isVisible())
                        .forNoMoreThan(15).seconds(),
                WaitUntil.the(PaginaCheckout.CASILLA_AUTORIZACION, isEnabled())
                        .forNoMoreThan(15).seconds()
        );

        String precioProducto = obtenerTexto(PaginaCheckout.PRECIO_PRODUCTO_EN_RESUMEN, actor);
        String totalPedido = obtenerTexto(PaginaCheckout.TOTAL_PEDIDO, actor);
        actor.remember(PRECIO_PRODUCTO, normalizarImporte(precioProducto));
        actor.remember(TOTAL_PEDIDO, normalizarImporte(totalPedido));

        hacerClicEnElementoActual(actor, PaginaCheckout.CASILLA_AUTORIZACION);
        actor.attemptsTo(
                WaitUntil.the(PaginaCheckout.BOTON_REALIZAR_PEDIDO, isVisible())
                        .forNoMoreThan(15).seconds(),
                WaitUntil.the(PaginaCheckout.BOTON_REALIZAR_PEDIDO, isEnabled())
                        .forNoMoreThan(15).seconds(),
                Click.on(PaginaCheckout.BOTON_REALIZAR_PEDIDO)
        );
    }

    private <T extends Actor> void hacerClicEnElementoActual(
            T actor,
            net.serenitybdd.screenplay.targets.Target target
    ) {
        StaleElementReferenceException ultimoError = null;
        for (int intento = 0; intento < 3; intento++) {
            try {
                actor.attemptsTo(Click.on(target));
                return;
            } catch (StaleElementReferenceException error) {
                ultimoError = error;
            }
        }
        throw ultimoError;
    }

    private String normalizarImporte(String importe) {
        java.util.regex.Matcher importes = java.util.regex.Pattern
                .compile("(\\d{1,3}(?:\\.\\d{3})*(?:,\\d+)?|\\d+(?:,\\d+)?)")
                .matcher(importe);
        String importeCompleto = "";
        while (importes.find()) {
            importeCompleto = importes.group(1);
        }

        if (importeCompleto.isEmpty()) {
            throw new IllegalArgumentException(
                    "No se encontró un importe válido en el texto: " + importe
            );
        }

        return importeCompleto
                .replace(".", "")
                .replace(',', '.');
    }

    private <T extends Actor> String obtenerTexto(
            net.serenitybdd.screenplay.targets.Target target,
            T actor
    ) {
        net.serenitybdd.core.pages.WebElementFacade elemento = target.resolveFor(actor);
        String texto = elemento.getText();
        return texto.isBlank() ? elemento.getAttribute("innerHTML") : texto;
    }

}
