# 🧪 API Testing con Rest-Assured y TestNG

Este proyecto contiene pruebas automatizadas para validar el endpoint `/users` del servicio público [JSONPlaceholder](https://jsonplaceholder.typicode.com), utilizando Rest-Assured y TestNG. Las pruebas cubren validaciones funcionales, de contenido y de rendimiento.

## 📦 Estructura del Proyecto

```bash
src/test/java/cl/mauriciovera/test/
├── UserApiTest.java
└── UserApiParametrizadoTest.java
```

## 🛠️ Tecnologías Utilizadas

- **Rest-Assured**: Framework para pruebas HTTP en Java.
- **TestNG**: Framework de testing con soporte para parametrización.
- **Hamcrest**: Librería para aserciones legibles (`equalTo`, `lessThan`, etc.).

## ✅ Pruebas Incluidas

### `UserApiTest.java`

Pruebas unitarias sobre el endpoint `/users/1`:

- **Validación de contenido**: Verifica que el usuario con ID 1 tenga el nombre esperado (`Leanne Graham`).
- **Validación de rendimiento**: Asegura que la respuesta llegue en menos de 2 segundos.
- **Logs de petición/respuesta**: Activados para facilitar debugging y trazabilidad.

### `UserApiParametrizadoTest.java`

Pruebas parametrizadas para múltiples IDs de usuario:

- Utiliza `@DataProvider` para iterar sobre los IDs del 1 al 5.
- Verifica que el campo `id` en la respuesta coincida con el solicitado.
- Modular y escalable para ampliar cobertura fácilmente.

## 🚀 Ejecución de Pruebas

Asegúrate de tener Maven configurado y ejecuta:

```bash
mvn clean test
```

## 📌 Notas Técnicas

- El `baseURI` se configura una sola vez en `@BeforeClass` para evitar duplicación.
- Las pruebas están diseñadas para ser autónomas y no requieren autenticación.
- Puedes extender fácilmente los `DataProvider` para incluir casos negativos o IDs inexistentes.

## 📂 Buenas Prácticas Aplicadas

- Modularización de pruebas por tipo (unitarias vs parametrizadas).
- Uso de `ContentType.JSON` para validar formato de respuesta.
- Aserciones claras y defendibles con Hamcrest.
- Logs completos para facilitar análisis en caso de fallos.

## 🧠 Autor

Mauricio Vera — QA Automation Specialist  
Especializado en validación visual, arquitectura de componentes y trazabilidad técnica.
