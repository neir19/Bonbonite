package org.example.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaVenta {
    public static final Target TOTAL_PEDIDO =

            Target.the("Total en la pantalla de venta exitosa")
                    .located(By.xpath("//span[@class='woocommerce-Price-amount amount']"));

}
