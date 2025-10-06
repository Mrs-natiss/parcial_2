# Inventario de Material Didáctico

Proyecto Spring Boot (Maven) minimalista para el *Sistema de Control de Inventario de Material Didáctico*.
Paquete base: `com.inventario`

## Estructura
- `entities` — clases `Material` y `Category`.
- `repository` — interfaz `MaterialRepository` y `InMemoryMaterialRepository` (almacenamiento en memoria).
- `service` — `MaterialService` con la lógica para registrar materiales, actualizar cantidades y listar.
- `controller` — endpoints REST en `/api/materiales`.
- `dto` — `MaterialRequest` y `UpdateQuantityRequest`.

## Endpoints principales
- `POST /api/materiales` — registrar material.
- `GET /api/materiales` — listar todo el inventario.
- `GET /api/materiales/activos` — listar materiales activos.
- `PATCH /api/materiales/cantidad` — actualizar cantidad (reemplazo o suma).

## Ejecutar
1. Importar el proyecto en IntelliJ o VS Code como proyecto Maven.
2. Ejecutar `mvn spring-boot:run` o ejecutar la clase `InventarioApplication`.
3. Probar los endpoints (por ejemplo con curl o Postman).

## Aplicación de POO (resumen)
- **Encapsulamiento:** atributos privados y getters/setters.
- **Abstracción:** `MaterialService` oculta la lógica del repositorio.
- **Herencia/Polimorfismo:** preparado para extender `Material` si se requiere.

## Notas
- Este proyecto usa un repositorio en memoria. Para persistencia real, cambiar a Spring Data JPA.
- Si quieres que agregue tests, seguridad o persistencia con H2 o MySQL, dímelo y lo integro.
