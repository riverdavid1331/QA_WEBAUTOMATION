package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import com.nttdata.core.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(WebDriverManager.getDriver());

    @Given("estoy en la página de la tienda")
    public void estoy_en_la_pagina_de_la_tienda() {
        WebDriverManager.getDriver().get("https://qalab.bensg.com/store");
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void me_logueo_con_mi_usuario_y_clave(String usuario, String clave) {
        loginPage.login(usuario, clave);
    }
}
