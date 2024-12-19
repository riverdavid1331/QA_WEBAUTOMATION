package com.nttdata.steps;

import com.nttdata.page.CartPage;
import com.nttdata.page.HomePage;
import com.nttdata.core.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {

    HomePage homePage = new HomePage(WebDriverManager.getDriver());
    CartPage cartPage = new CartPage(WebDriverManager.getDriver());

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navego_a_la_categoria_y_subcategoria(String categoria, String subcategoria) {
        homePage.navigateToCategory();
    }

    @And("agrego 2 unidades del primer producto al carrito")
    public void agrego_2_unidades_del_primer_producto_al_carrito() {
        // Implementar lógica para agregar al carrito (esto puede depender de la estructura de la tienda)
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void valido_en_el_popup_la_confirmacion_del_producto_agregado() {
        cartPage.verifyProductConfirmation();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void valido_en_el_popup_que_el_monto_total_sea_calculado_correctamente() {
        cartPage.verifyTotalAmount();
    }

    @When("finalizo la compra")
    public void finalizo_la_compra() {
        cartPage.proceedToCheckout();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void valido_el_titulo_de_la_pagina_del_carrito() {
        String title = WebDriverManager.getDriver().getTitle();
        assert title.contains("Carrito");
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvo_a_validar_el_calculo_de_precios_en_el_carrito() {
        cartPage.verifyTotalAmount();
    }
}

