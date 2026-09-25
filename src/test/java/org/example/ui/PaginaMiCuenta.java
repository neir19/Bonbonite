package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class PaginaMiCuenta {

    public static final Target OPCION_MI_CUENTA = Target.the("Opción 'Mi cuenta' del encabezado")
            .located(By.xpath("//div[@id='toggle-account-menu']"));

    public static final Target OPCION_REGISTRATE = Target.the("Opción 'Regístrate' de la cuenta")
            .located(By.id("show_register"));

    public static final Target CAMPO_CEDULA = Target.the("Campo de número de cédula del registro")
            .located(By.id("reg_username"));

    public static final Target CAMPO_NOMBRES = Target.the("Campo de nombres del registro")
            .located(By.id("first_name"));

    public static final Target CAMPO_APELLIDOS = Target.the("Campo de apellidos del registro")
            .located(By.id("last_name"));

    public static final Target CAMPO_CORREO = Target.the("Campo de correo electrónico del registro")
            .located(By.id("reg_email"));

    public static final Target CAMPO_CONTRASENA = Target.the("Campo de contraseña del registro")
            .located(By.id("reg_password"));

    public static final Target CAMPO_CONFIRMACION_CONTRASENA = Target.the("Campo de confirmación de la contraseña del registro")
            .located(By.id("reg_password2"));

    public static final Target CASILLA_AUTORIZACION_DATOS = Target.the("Casilla de autorización para el tratamiento de datos personales")
            .located(By.id("privacy_policy_reg"));

    public static final Target BOTON_REGISTRARME = Target.the("Botón 'Registrarme' del formulario de registro")
            .located(By.cssSelector("button[name='register']"));

    public static final Target CAMPO_USUARIO_LOGIN = Target.the("Campo de cédula del inicio de sesión")
            .located(By.id("username"));

    public static final Target CAMPO_CONTRASENA_LOGIN = Target.the("Campo de contraseña del inicio de sesión")
            .located(By.id("password"));

    public static final Target BOTON_INICIAR_SESION = Target.the("Botón 'Iniciar Sesión'")
            .located(By.cssSelector("button[name='login']"));

    public static final Target OPCION_DETALLES_DE_CUENTA = Target.the("Opción 'Detalles de la cuenta'")
            .located(By.xpath("(//a[contains(@href, 'account')])[3]"));

    public static final Target CAMPO_NOMBRES_CUENTA = Target.the("Campo de nombres de la cuenta")
            .located(By.id("account_first_name"));

    public static final Target CAMPO_APELLIDOS_CUENTA = Target.the("Campo de apellidos de la cuenta")
            .located(By.id("account_last_name"));

    public static final Target CAMPO_CORREO_CUENTA = Target.the("Campo de correo de la cuenta")
            .located(By.id("account_email"));

    public static final Target BOTON_GUARDAR_CAMBIOS_CUENTA = Target.the("Botón para guardar los cambios de la cuenta")
            .located(By.cssSelector("button[name='save_account_details']"));

    public static final Target MENSAJE_DATOS_CUENTA_ACTUALIZADOS = Target.the("Confirmación de actualización de los datos de la cuenta")
            .located(By.xpath("//span[normalize-space()='Datos personales actualizados correctamente']"));

    public static final Target MENSAJE_ERROR_LOGIN = Target.the("Mensaje de error del inicio de sesión")
            .located(By.cssSelector(
                    ".woocommerce-error, "
                            + ".woocommerce-notices-wrapper .woocommerce-error, "
                            + ".login-errors, "
                            + ".woocommerce-form-login .woocommerce-error"));

    public static final Target MENSAJE_ERROR_REGISTRO = Target.the("Mensaje de error del registro")
            .located(By.cssSelector(
                    ".woocommerce-error, "
                            + ".woocommerce-notices-wrapper .woocommerce-error, "
                            + ".registration-error, "
                            + ".woocommerce-form-register .woocommerce-error"));

    public static final Target TITULO_HOME = Target.the("mensaje de bienvenida")
            .located(By.xpath("//h3[contains(text(),'Hola')]"));
    public static final Target BOTON_ACTUALIZAR_DATOS = Target.the("Botón para actualizar los datos de la cuenta")
            .located(By.xpath("(//button[contains(@type,'button')][contains(text(),'Actualizar')])[1]"));
    public static  final Target CAMPO_NOMBRES_CUENTA_ACTUALIZAR = Target.the("Campo de nombres de la cuenta para actualizar")
            .located(By.xpath("(//input[@name='first_name'])[1]"));
    public static final Target CAMPO_APELLIDOS_CUENTA_ACTUALIZAR = Target.the("Campo de apellidos de la cuenta para actualizar")
            .located(By.xpath("(//input[@name='last_name'])[1]"));
    public static  final  Target BOTON_GUARDAR_CAMBIOS_CUENTA_ACTUALIZAR = Target.the("Botón para guardar los cambios de la cuenta al actualizar")
            .located(By.xpath("(//button[@class='border-2 save-info-btn border-black uppercase py-2 block w-fit px-16 font-semibold text-sm text-center transition-all bg-black text-white'])[1]"));

    public static final Target CAMPO_CORREO_CUENTA_ACTUALIZAR = Target.the("Campo de correo de la cuenta para actualizar")
            .located(By.xpath("(//input[contains(@name,'aux_email')])[1]"));

    private PaginaMiCuenta() {
    }
}
