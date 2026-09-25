package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class PaginaZapatosMujer {


    public static final Target CABECERA = Target.the("mensaje de cabecera").located(By.id("header"));

    private PaginaZapatosMujer() {
    }
}