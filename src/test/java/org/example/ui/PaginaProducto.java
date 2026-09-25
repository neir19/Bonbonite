package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class PaginaProducto {

    public static final Target TITULO_PRODUCTO = Target.the("Título del producto")
            .located(By.cssSelector("h1.product_title, h1, .product-title"));

    public static final Target TALLAS_DISPONIBLES = Target.the("Botones de tallas disponibles")
            .located(By.xpath("//div[contains(@class,'variation-buttons')]//button[contains(@class,'variation-button') and not(contains(@class,'disabled')) and not(@disabled)]"));

    public static final Target BOTON_COMPRAR_AHORA = Target.the("Botón 'Comprar Ahora'")
            .located(By.xpath("//a[contains(@class,'buy-now') and normalize-space()='Comprar Ahora']"
                    + " | //a[normalize-space()='Comprar Ahora']"));
    public static final Target BOTON_COMPRAR_AHORA_DESHABILITADO = Target.the("Botón 'Comprar Ahora'")
            .located(By.xpath("//div[contains(@class,' woocommerce-variation-add-to-cart-disabled')]"));
    public static final Target ACEPTAR_TODO = Target.the("botón Aceptar todo cookies " )
            .located(By.xpath("//div[contains(text(),' Aceptar todo ')]"));

    private PaginaProducto() {
    }
}
