package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class PaginaCarrito {



    public static final Target BOTON_FINALIZAR_COMPRA = Target.the("Botón 'Finalizar compra'")
            .located(By.cssSelector(".cart_totals a.checkout-button, a.checkout-button"));

    public static final Target BOTON_CONTINUAR = Target.the("Botón para continuar con la compra")
            .located(By.xpath("//button[text()='Continuar']"));



    private PaginaCarrito() {
    }
}
