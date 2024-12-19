package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    // Elementos del carrito
    private By productConfirmationPopup = By.id("product-confirmation-popup");
    private By totalAmountPopup = By.id("total-amount-popup");
    private By checkoutButton = By.id("checkout-button");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductConfirmation() {
        driver.findElement(productConfirmationPopup).isDisplayed();
    }

    public void verifyTotalAmount() {
        driver.findElement(totalAmountPopup).getText();
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}

