package com.nttdata.core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {

    private static WebDriver driver;
    private static Scenario scenario;

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private static void initializeDriver() {
        // Configuración de WebDriver y propiedades
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Before(order = 0)
    public void setUp() {
        // Inicialización automática antes de cada escenario
        getDriver();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        WebDriverManager.scenario = scenario;
    }

    @After
    public void tearDown() {
        // Cierre del driver al finalizar el escenario
        if (driver != null) {
            driver.quit();
            driver = null; // Para evitar reutilización en el siguiente escenario
        }
    }

    public static void captureScreenshot() {
        // Adjuntar captura de pantalla al reporte
        if (scenario != null && driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Evidencia");
        }
    }
}
