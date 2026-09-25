package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class PaginaCheckout {

    public static final Target FORMULARIO_CHECKOUT = Target.the("Formulario o tabla de finalización de compra")
            .located(By.cssSelector("form.checkout, #order_review, .woocommerce-checkout-review-order, .woocommerce-checkout"));

    public static final Target OPCION_COMPRAR_COMO_INVITADO = Target.the("Opción para comprar como invitado")
            .located(By.xpath("//*[self::button or self::a or self::label or @role='button']"
                    + "[contains(translate(normalize-space(.), "
                    + "'ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚ', 'abcdefghijklmnopqrstuvwxyzáéíóú'), 'invitado')]"));

    public static final Target CAMPO_USUARIO = Target.the("Campo de usuario del checkout")
            .located(By.id("username"));

    public static final Target CAMPO_CONTRASENA = Target.the("Campo de contraseña del checkout")
            .located(By.id("password"));

    public static final Target BOTON_INICIAR_SESION = Target.the("Botón de inicio de sesión del checkout")
            .located(By.cssSelector(
                    "form.checkout_login button[name='login'], "
                            + "form.woocommerce-form-login button[name='login'], "
                            + "button[name='login']"));

    public static final Target CAMPO_NOMBRES = Target.the("Campo de nombres de facturación")
            .located(By.id("billing_first_name"));

    public static final Target CAMPO_APELLIDOS = Target.the("Campo de apellidos de facturación")
            .located(By.id("billing_last_name"));

    public static final Target CAMPO_CORREO = Target.the("Campo de correo de facturación")
            .located(By.id("billing_email"));

    public static final Target CAMPO_TELEFONO = Target.the("Campo de teléfono de facturación")
            .located(By.id("billing_phone"));

    public static final Target CAMPO_DIRECCION = Target.the("Campo de dirección de facturación")
            .located(By.id("billing_address_1"));

    public static final Target CAMPO_CIUDAD = Target.the("Campo de ciudad de facturación")
            .located(By.id("billing_city"));

    public static final Target SELECTOR_DEPARTAMENTO = Target.the("Selector de departamento de facturación")
            .located(By.id("billing_state"));

    public static final Target SELECTOR_PAIS = Target.the("Selector de país de facturación")
            .located(By.id("billing_country"));

    public static final Target CAMPO_CODIGO_POSTAL = Target.the("Campo de código postal de facturación")
            .located(By.id("billing_postcode"));
    public static  final Target CAMPO_DOCUMENTO = Target.the("Campo de documento de facturación")
            .located(By.id("billing_user_login"));

    public static final Target CASILLA_AUTORIZACION = Target.the("Casilla de autorización de términos y condiciones")
            .located(By.id("terms"));

    public static final Target BOTON_REALIZAR_PEDIDO = Target.the("Botón 'Realizar pedido'")
            .located(By.cssSelector("#place_order, button[name='woocommerce_checkout_place_order']"));

    public static final Target PRECIO_PRODUCTO_EN_RESUMEN = Target.the("Precio del producto en el resumen")
            .located(By.cssSelector(
                    "#order_review .product-total .amount, "
                            + "#order_review .product-subtotal .amount, "
                            + ".woocommerce-checkout-review-order-table .product-total .amount, "
                            + ".woocommerce-checkout-review-order-table .product-subtotal .amount"));

    public static final Target TOTAL_PEDIDO = Target.the("Total del pedido")
            .located(By.cssSelector(
                    "#order_review .order-total strong"));


    private PaginaCheckout() {
    }
}
