package org.example.interactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;

public class ScrollAlInicio implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {

        JavascriptExecutor js =
                (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();

        js.executeScript(
                "window.scrollTo({ top: 0, left: 0, behavior: 'instant' });"
        );
    }

    public static ScrollAlInicio deLaPagina() {
        return Tasks.instrumented(ScrollAlInicio.class);
    }


}

