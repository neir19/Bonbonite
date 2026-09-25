# language: es
Característica: Registro de nuevo usuario
  Como usuario de Bon-Bonite
  Quiero registrarme en el sitio web
  Para acceder a mi cuenta y realizar compras

  @registro
  Esquema del escenario: Registrar exitosamente un nuevo usuario
    Dado que el usuario se encuentra en la página de zapatos para mujer de Bon-Bonite
    Cuando el usuario selecciona la opción "Mi cuenta"
    Y selecciona la opción "Regístrate"
    Y diligencia los campos del registro con los siguientes datos:
      | cedula   | nombres   | apellidos   | correo   | contraseña | confirmacion |
      | <cedula> | <nombres> | <apellidos> | <correo> | <password> | <password>   |
    Y acepta la autorización para el tratamiento de sus datos personales
    Y selecciona el botón "Registrarme"
    Entonces debe visualizar la cuenta del usuario autenticado

    Ejemplos:
      | cedula      | nombres  | apellidos | correo            | password   |
      | 10202091235 | Mauricio | Restrepo  | usuario4@test.com | Test@12345 |

  @registro @registro-no-exitoso
  Esquema del escenario: Rechazar registro con datos ya registrados
    Dado que el usuario se encuentra en la página de zapatos para mujer de Bon-Bonite
    Cuando el usuario selecciona la opción "Mi cuenta"
    Y selecciona la opción "Regístrate"
    Y diligencia los campos del registro con los siguientes datos:
      | cedula   | nombres   | apellidos   | correo   | contraseña | confirmacion |
      | <cedula> | <nombres> | <apellidos> | <correo> | <password> | <password>   |
    Y acepta la autorización para el tratamiento de sus datos personales
    Y selecciona el botón "Registrarme"
    Entonces debe visualizar un mensaje de error de registro

    Ejemplos:
      | cedula      | nombres | apellidos | correo            | password   |
      | 10202091234 | Usuario | Existente | usuario2@test.com | Test@12345 |