package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.ui.PaginaVenta;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TotalPedidoCoincideConProducto implements Question<Boolean> {

    private static final String PRECIO_PRODUCTO = "precioProductoCheckout";


    public static TotalPedidoCoincideConProducto esIgualAlPrecioDelProducto() {
        return new TotalPedidoCoincideConProducto();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(PaginaVenta.TOTAL_PEDIDO, isVisible())
                .forNoMoreThan(15).seconds());
        String precioProducto = actor.recall(PRECIO_PRODUCTO);
        String totalPedido = PaginaVenta.TOTAL_PEDIDO.resolveFor(actor).getText().replace("$","").replace(",",".") ;

        if (!precioProducto.equals(totalPedido)) {
            throw new AssertionError(
                    "El precio del producto (" + precioProducto
                            + ") no coincide con el total del pedido (" + totalPedido + ")"
            );
        }
        return true;
    }
}
