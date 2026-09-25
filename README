# Automatizacion E2E de Bon-Bonite

Proyecto de automatizacion de pruebas funcionales end-to-end para el sitio web de [Bon-Bonite](https://www.bon-bonite.com/), aplicando BDD con escenarios escritos en espanol y el patron Screenplay.

## Objetivo

Validar los flujos principales de un usuario en la tienda:

- Navegacion hacia la categoria de zapatos para mujer.
- Inicio de sesion con credenciales validas e invalidas.
- Registro de usuarios nuevos y rechazo de datos ya registrados.
- Seleccion de productos por categoria.
- Seleccion de tallas disponibles.
- Compra como invitado.
- Inicio de sesion durante el checkout.
- Diligenciamiento de datos de contacto, autorizacion de tratamiento de datos y confirmacion del pedido.
- Validacion del producto y del total mostrado al finalizar la compra.

## Stack tecnologico

| Tecnologia | Version / uso |
| --- | --- |
| Java | JDK 17 como version objetivo de compilacion |
| Gradle | 9.5.0 mediante Gradle Wrapper |
| Serenity BDD | 5.3.10 para automatizacion, Screenplay y reportes |
| Serenity Gradle Plugin | 5.3.9 |
| Serenity Screenplay WebDriver | Interaccion con el navegador |
| Selenium WebDriver | Automatizacion del navegador a traves de Serenity |
| WebDriverManager | 5.9.2, gestion del driver del navegador |
| Cucumber | 7.34.2 para BDD y escenarios Gherkin |
| JUnit Platform | Suite de ejecucion y motor JUnit |
| JUnit Jupiter Engine | 6.0.3 |
| Chrome | Navegador configurado para la ejecucion |

### JDK

El proyecto compila con `sourceCompatibility` y `targetCompatibility` en Java 17. Se recomienda utilizar JDK 17.0.17 o superior y configurar `JAVA_HOME` apuntando a un JDK instalado localmente. No se debe configurar una ruta absoluta mediante `org.gradle.java.home`, ya que impediria ejecutar el proyecto en otros equipos.

## Casos de prueba implementados

Los escenarios se encuentran en `src/test/resources/features/` y utilizan tablas de ejemplos para reutilizar los flujos con diferentes datos.

### Inicio de sesion (`login.feature`)

1. Inicio de sesion exitoso con credenciales registradas y validacion de la cuenta autenticada.
2. Rechazo de inicio de sesion con credenciales invalidas y validacion del mensaje de error.

### Registro (`registro.feature`)

3. Registro exitoso de un nuevo usuario, incluyendo autorizacion para el tratamiento de datos.
4. Rechazo del registro cuando los datos ya se encuentran registrados y validacion del mensaje de error.

### Compra (`compra_producto.feature`)

5. Compra como invitado de un producto seleccionado aleatoriamente en la categoria **Bolsos**.
6. Compra como invitado de un producto seleccionado aleatoriamente en la categoria **Zapatos**.
7. Compra de un producto iniciando sesion durante el checkout.

En total hay 6 esquemas de escenario y 7 ejecuciones parametrizadas a partir de sus ejemplos.

## Funcionalidades cubiertas

- Acceso al sitio y navegacion a la pagina de zapatos para mujer.
- Navegacion por categorias de productos.
- Seleccion aleatoria de producto y de una talla disponible.
- Flujo de carrito y checkout.
- Compra sin autenticacion previa.
- Autenticacion durante el checkout.
- Formularios de inicio de sesion, registro y datos de compra.
- Validacion de credenciales invalidas.
- Validacion de registro duplicado.
- Aceptacion del tratamiento de datos personales.
- Confirmacion del pedido.
- Verificacion del producto comprado y del total del pedido.

## Estructura principal

```text
.
├── build.gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
├── src
│   └── test
│       ├── java/org/example
│       │   ├── interactions
│       │   ├── model
│       │   ├── questions
│       │   ├── runners
│       │   ├── stepdefinitions
│       │   ├── tasks
│       │   ├── ui
│       │   └── utils
│       └── resources
│           ├── features
│           ├── junit-platform.properties
│           └── serenity.conf
└── gradle/wrapper
```

El codigo de prueba sigue el patron Screenplay:

- `tasks`: acciones de negocio que ejecuta el actor.
- `interactions`: interacciones reutilizables con la interfaz.
- `questions`: validaciones y consultas sobre el estado de la aplicacion.
- `ui`: localizadores y componentes de las paginas.
- `stepdefinitions`: relacion entre los pasos Gherkin y las acciones.
- `model`: datos usados en los formularios.
- `runners`: configuracion de ejecucion de Cucumber con JUnit Platform.

## Configuracion de ejecucion

- URL bajo prueba: `https://www.bon-bonite.com/`
- Navegador: Chrome.
- Ventana: maximizada.
- Opciones: `--start-maximized`, `--disable-notifications` e `--incognito`.
- Tiempo de espera configurado: 10 segundos.
- Ejecucion paralela: 2 hilos.
- Reportes: Serenity y reporte HTML de Cucumber.

La configuracion se encuentra en:

- `src/test/resources/serenity.conf`
- `src/test/resources/junit-platform.properties`
- `src/test/java/org/example/runners/TestRunner.java`

## Ejecucion

En macOS o Linux:

```bash
./gradlew clean test
```

En Windows:

```bat
gradlew.bat clean test
```

Tambien se puede ejecutar solo la limpieza:

```bash
./gradlew clean
```

Los reportes generados localmente se guardan en `target/` y no deben subirse al repositorio. Los artefactos de compilacion y las configuraciones locales de IDE tambien estan excluidos mediante `.gitignore`.

## Requisitos

- JDK 17.0.17 o superior.
- Google Chrome instalado.
- Conexion a internet para acceder al sitio bajo prueba y resolver dependencias.
- Permisos para ejecutar el navegador en modo automatizado.

Los datos de prueba se encuentran actualmente en los archivos `.feature`. Para ejecuciones contra otros ambientes, se recomienda externalizarlos y evitar utilizar credenciales reales.
