package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // Elementos de la página principal
    private By categoryLink = By.linkText("Clothes");
    private By subCategoryLink = By.linkText("Men");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCategory() {
        driver.findElement(categoryLink).click();
        driver.findElement(subCategoryLink).click();
    }
}

