# VetTurno - La Agenda Digital de Veterinaria Huellitas

## Historia del Proyecto
Doña Marta abrió **Veterinaria Huellitas** hace seis años en su comunidad. Atiende la clínica junto al Dr. Andrés y a Paula en recepción. Debido a que la agenda se gestionaba en papel y chats de WhatsApp, surgían cruces de citas y pérdida de datos. **VetTurno** es una API REST profesional diseñada para registrar responsables, mascotas y veterinarios, agendar citas sin cruces de horario y consultar la agenda de manera ordenada y persistente.

## Tecnologías Utilizadas
* **Java**: 17
* **Framework**: Spring Boot
* **Gestor de dependencias**: Maven
* **Base de datos**: MySQL
* **Persistencia**: Spring Data JPA / Hibernate
* **Seguridad**: Spring Security + JWT
* **Documentación**: OpenAPI 3 / Swagger UI

## Arquitectura del Proyecto
Arquitectura por capas bajo el paquete base `com.veterinaria.vetturno`:
* `model`: Entidades JPA que mapean las tablas en MySQL.
* `repository`: Interfaces de acceso a datos (`JpaRepository`).
* `service`: Reglas de negocio y validación de citas.
* `controller`: Endpoints y manejo de peticiones HTTP.
* `dto`: Objetos de transferencia de datos para peticiones y respuestas desacopladas.
* `security`: Configuración de filtros, roles (USER/ADMIN) y tokens JWT.
* `config`: Configuración de documentación OpenAPI/Swagger.
* `exception`: Manejo centralizado de excepciones con respuestas uniformes.

## Cómo Ejecutar el Proyecto
1. Clonar el repositorio.
2. Crear la base de datos en MySQL:
   ```sql
   CREATE DATABASE vetturno;
   ```
