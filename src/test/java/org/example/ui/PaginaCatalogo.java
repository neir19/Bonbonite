package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class PaginaCatalogo {

    public static final Target OPCION_CATEGORIA = Target.the("Opción de categoría '{0}' en el menú")
            .locatedBy("//ul[@id='menu-categories-menu']//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚ', 'abcdefghijklmnopqrstuvwxyzáéíóú'), translate('{0}', 'ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚ', 'abcdefghijklmnopqrstuvwxyzáéíóú'))] | //nav//a[contains(text(), '{0}')]");

    public static final Target PRODUCTOS = Target.the("Productos del catálogo")
            .located(By.xpath("//div[contains(@class,'product_list')]//div[contains(@class,'product-wrapper-with-variation')]//a"));


    private PaginaCatalogo() {
    }
}
