Feature: Product - Store

  Como automatizador principal de NTT
  Quiero automatizar las pruebas de regresión de la tienda en línea
  Para asegurar la integridad de la página y la funcionalidad del carrito

  Scenario Outline: Validación del precio de un producto

    Given estoy en la página de la tienda
    And me logueo con mi usuario "<usuario>" y clave "<clave>"
    When navego a la categoria "Clothes" y subcategoria "Men"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito

    Examples:
      | usuario                   | clave          |
      | riverdavid1331@gmail.com  | HOLAMUNDO123   |
      | invalido@gmail.com        | PASSWORD12345  |
