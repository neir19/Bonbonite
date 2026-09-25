package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

public class Hooks {

    @Before
    public void prepararElEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void cerrarElNavegador() {
        if (ThucydidesWebDriverSupport.isDriverInstantiated()) {
            ThucydidesWebDriverSupport.closeDriver();
        }
    }
}