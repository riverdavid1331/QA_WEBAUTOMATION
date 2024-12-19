package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    // Elementos del carrito
    private By productConfirmationPopup = By.id("product-confirmation-popup");
    private By totalAmountPopup = By.id("total-amount-popup");
    private By checkoutButton = By.id("checkout-button");

    // Constructor que inicializa el WebDriver
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Verifica la confirmación del producto agregado al carrito
    public void verifyProductConfirmation() {
        driver.findElement(productConfirmationPopup).isDisplayed();
    }

    // Verifica el monto total del carrito
    public void verifyTotalAmount() {
        driver.findElement(totalAmountPopup).getText();
    }

    // Procede al proceso de pago
    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}


