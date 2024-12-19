package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // Elementos de la página principal
    private By categoryLink = By.linkText("Clothes");
    private By subCategoryLink = By.linkText("Men");

    // Constructor que inicializa el WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Método para navegar a la categoría y subcategoría
    public void navigateToCategory() {
        driver.findElement(categoryLink).click(); // Clic en "Clothes"
        driver.findElement(subCategoryLink).click(); // Clic en "Men"
    }
}
