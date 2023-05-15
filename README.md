
# BCI User Management API

Este repositorio contiene la API de Users para el ejercicio BCI


## Overview

Esta api fue generada con el proyecto [OpenAPI Generator](https://openapi-generator.tech).


La biblioteca de desarrollo que se ejecuta es [springfox](https://github.com/springfox/springfox)

Puedes acceder a la documentación auto-generada en: 
http://localhost:8080/

Se puede cambiar el puerto en application.properties

Esta app utiliza una base de datos en memoria **H2**, que es generada en tiempo de ejecución del proyecto

El proceso de build vía **Maven**.

## Requerimientos

- JAVA 11 JDK
- Maven 3.0 +
- Lombok


## Ejecución local


Existen múltiples maneras de ejecutar un proyeto Spring Boot de manera local
Una manera es ejecutar el método `main` en el archivo Invoker (`cl.bci.invoker.OpenAPI2SpringBoot` class) desde tu IDE.

Alternativamente, se puede utilizar el [plugin Maven Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) de esta manera:

```shell
mvn spring-boot:run
```

Igualmente, se puede generar un paquete `jar`, y luego ejecutar

```shell
java -jar users-api-1.0.0.jar
```

Para efectos prácticos, se incluye el jar autocontenido

## Test

Para testear esta app, se puede ejecutar, y luego acceder a http://localhost:8080/, y mendiante Swagger UI se puede probar cada método

