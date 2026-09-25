# language: es
Característica: Compra de productos por categoría
  Como usuario de Bon-Bonite
  Quiero navegar por las diferentes categorías de productos
  Para seleccionar un producto, elegir una talla disponible y realizar el proceso de compra

  @compraComoInvitado
  Esquema del escenario: Seleccionar y comprar un producto al azar por categoría
    Dado que el usuario se encuentra en la página de zapatos para mujer de Bon-Bonite
    Cuando el usuario ingresa a la categoría "<categoria>"
    Y selecciona un producto al azar de la categoría
    Y selecciona una talla de las disponibles
    Y realiza la venta del producto seleccionado
    Y finaliza la compra como invitado
    Y diligencia el formulario de venta como invitado con los datos "<documento>", "<nombres>", "<apellidos>", "<correo>", "<telefono>", "<direccion>", "<ciudad>", "<departamento>", "<pais>", "<codigoPostal>"
    Y autoriza el tratamiento de datos y realiza el pedido
    Entonces debe visualizar el producto en la pantalla de finalización de compra
    Y el total del pedido debe ser igual al precio del producto comprado

    Ejemplos:
      | categoria | documento|nombres | apellidos | correo | telefono | direccion | ciudad | departamento | pais | codigoPostal |
      | Bolsos   |12345675 |Ana     | Pérez     | ana.perez@example.com | 3105551234 | Calle 10 # 20-30 | Bogotá | Distrito Capital de Bogotá | Colombia | 110111 |
      | Zapatos   |12345675 |Ana     | Pérez     | ana.perez@example.com | 3105551234 | Calle 10 # 20-30 | Bogotá | Distrito Capital de Bogotá | Colombia | 110111 |
#      | Bolsos     |
#      | Cinturones |

  @compraConUsuario
  Esquema del escenario: Comprar un producto iniciando sesión en el checkout
    Dado que el usuario se encuentra en la página de zapatos para mujer de Bon-Bonite
    Cuando el usuario ingresa a la categoría "<categoria>"
    Y selecciona un producto al azar de la categoría
    Y selecciona una talla de las disponibles
    Y realiza la venta del producto seleccionado
    Y inicia sesión en el checkout con usuario "<usuario>" y contraseña "<contrasena>"
    Y diligencia el formulario de venta como invitado con los datos "<telefono>", "<direccion>", "<ciudad>", "<departamento>", "<pais>", "<codigoPostal>"
    Y autoriza el tratamiento de datos y realiza el pedido
    Entonces debe visualizar el producto en la pantalla de finalización de compra
    Y el total del pedido debe ser igual al precio del producto comprado

    Ejemplos:
      | categoria | usuario     | contrasena | telefono     | direccion        | ciudad | departamento                    | pais     | codigoPostal |
      | Zapatos   | 10202091234 | Test@12345 | 3105551234  | Calle 10 # 20-30 | Bogotá | Distrito Capital de Bogotá     | Colombia | 110111       |
