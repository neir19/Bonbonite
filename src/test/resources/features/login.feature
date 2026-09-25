# language: es
Característica: Inicio de sesión de usuario
  Como usuario de Bon-Bonite
  Quiero iniciar sesión en el sitio web
  Para acceder a mi cuenta y gestionar mi información

  @login @login-exitoso
  Esquema del escenario: Iniciar sesión exitosamente con credenciales registradas
    Dado que el usuario se encuentra en la página de zapatos para mujer de Bon-Bonite
    Cuando el usuario selecciona la opción "Mi cuenta"
    Y diligencia los campos del inicio de sesión con los siguientes datos:
      | cedula      | contraseña  |
      | <cedula>    | <password>  |
    Y selecciona el botón "Iniciar Sesión"
    Entonces debe visualizar la cuenta del usuario autenticado

    Ejemplos:
      | cedula      | password    |
      | 10202091234 | Test@12345  |

  @login @login-no-exitoso
  Esquema del escenario: Rechazar inicio de sesión con credenciales inválidas
    Dado que el usuario se encuentra en la página de zapatos para mujer de Bon-Bonite
    Cuando el usuario selecciona la opción "Mi cuenta"
    Y diligencia los campos del inicio de sesión con los siguientes datos:
      | cedula      | contraseña  |
      | <cedula>    | <password>  |
    Y selecciona el botón "Iniciar Sesión"
    Entonces debe visualizar un mensaje de error de inicio de sesión

    Ejemplos:
      | cedula      | password       |
      | 00000000000 | ClaveInvalida1 |