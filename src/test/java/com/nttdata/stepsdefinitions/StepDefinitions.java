package com.nttdata.stepsdefinitions;

import com.nttdata.page.LoginPage;
import com.nttdata.page.HomePage;
import com.nttdata.page.CartPage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.WebDriverManager.*;

public class StepDefinitions {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;

    @Before
    public void setup() {
        driver = getDriver();
    }

    @After
    public void teardown() {
        closeDriver();
    }

    private void closeDriver() {
    }

    @Dado("que me encuentro en la página de login de la tienda")
    public void queMeEncuentroEnLaPaginaDeLogin() {
        driver.get("https://qalab.bensg.com/store");
        captureScreenshot();

        WebElement tituloLogin;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        tituloLogin = driver.findElement(By.id("login-title")); // ID de ejemplo
        wait.until(ExpectedConditions.visibilityOf(tituloLogin));
        System.out.println("Título visible: " + tituloLogin.getText());
    }

    @Cuando("inicio sesión con el usuario {string} y la contraseña {string}")
    public void inicioSesionConCredenciales(String usuario, String clave) {
        loginPage = new LoginPage(driver);
        loginPage.login(usuario, clave);
        captureScreenshot();
    }

    @Entonces("debería ver el título {string} en la página principal")
    public void validoTituloEnLaPaginaPrincipal(String tituloEsperado) {
        homePage = new HomePage(driver);
        String tituloActual = driver.getTitle();
        Assertions.assertTrue(tituloActual.contains(tituloEsperado),
                "El título no coincide. Esperado: " + tituloEsperado + ", Actual: " + tituloActual);
        captureScreenshot();
    }

    @Y("valido que al menos exista un producto en el carrito")
    public void validoProductoEnElCarrito() {
        cartPage = new CartPage(driver);
        WebElement popup = driver.findElement(By.id("product-confirmation-popup"));
        Assertions.assertTrue(popup.isDisplayed(), "No se encontró el popup de confirmación del producto.");
        captureScreenshot();
    }

    @Cuando("navego a la categoría {string} y subcategoría {string}")
    public void navegoACategoriaYSubcategoria(String categoria, String subcategoria) {
        homePage = new HomePage(driver);
        homePage.navigateToCategory();
        captureScreenshot();
    }

    @Entonces("valido que el monto total sea calculado correctamente")
    public void validoMontoTotalCalculadoCorrectamente() {
        cartPage = new CartPage(driver);
        cartPage.verifyTotalAmount();
        captureScreenshot();
    }
}
