package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    // Elementos de la página de login
    private By userInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");

    // Constructor que inicializa el WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Método para realizar login
    public void login(String username, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys(username);

        driver.findElement(userInput).sendKeys(username); // Ingresar el usuario
        driver.findElement(passwordInput).sendKeys(password); // Ingresar la contraseña
        driver.findElement(loginButton).click(); // Hacer clic en el botón de login
    }
}


