package com.nttdata.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports"},  // Generar reporte HTML
        stepNotifications = true,  // Activar notificaciones para los pasos
        features = "src/test/resources/features",  // Ruta donde se encuentran los archivos .feature
        glue = "com.nttdata.steps"  // Ruta donde se encuentran los archivos de pasos y definiciones
         //tags = "@test"
)
public class RunnerTest {
}

