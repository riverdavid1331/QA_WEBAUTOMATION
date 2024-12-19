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

    // Devuelve el WebDriver, creando uno si es necesario
    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    // Inicializa el WebDriver con las configuraciones necesarias
    private static void initializeDriver() {
        // Configuración de WebDriver y propiedades
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    // Configura el WebDriver antes de cada escenario
    @Before(order = 0)
    public void setUp() {
        getDriver(); // Inicializa el driver antes de cada escenario
    }

    // Asocia el escenario actual antes de la ejecución
    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        WebDriverManager.scenario = scenario;
    }

    // Cierra el WebDriver después de cada escenario
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Cierra el navegador
            driver = null; // Evita la reutilización del driver en el siguiente escenario
        }
    }

    // Captura una captura de pantalla durante la ejecución
    public static void captureScreenshot() {
        if (scenario != null && driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Evidencia"); // Adjunta la captura al reporte
        }
    }
}
