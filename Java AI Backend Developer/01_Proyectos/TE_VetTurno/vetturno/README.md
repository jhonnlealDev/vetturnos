# VetTurno - La Agenda Digital de Veterinaria Huellitas

## 1. Historia del Proyecto
Doña Marta abrió **Veterinaria Huellitas** hace seis años en su comunidad. Atiende la clínica junto al Dr. Andrés y a Paula en recepción. Debido a que la agenda se gestionaba en papel y chats de WhatsApp, surgían cruces de citas y pérdida de datos de contacto. 

**VetTurno** es una API REST profesional construida con Spring Boot para registrar responsables, mascotas y veterinarios, agendar citas garantizando la ausencia de cruces de horario y permitir la consulta organizada y persistente de la agenda clínica.

---

## 2. Alcance del MVP
* **Incluye**:
  * Autenticación y autorización basada en JWT con roles `USER` (recepción) y `ADMIN` (administración).
  * CRUD y consulta de Propietarios, Mascotas, Veterinarios y Citas.
  * Regla de negocio anti-cruces: prevención de horarios duplicados para un mismo veterinario.
  * Validación de fechas futuras para citas médicas.
  * Validación de entradas con Bean Validation y respuestas de error uniformes (`ApiError`).
  * Documentación interactiva con OpenAPI 3 y Swagger UI (con esquema Bearer Auth).
  * Persistencia relacional en MySQL mediante Spring Data JPA y Hibernate.
* **Fuera de alcance**: Historia clínica, facturación, pagos, tienda de mascotas o interfaz gráfica web/móvil.

---

## 3. Tecnologías Utilizadas
* **Lenguaje**: Java 17
* **Framework**: Spring Boot
* **Gestor de dependencias y construcción**: Maven
* **Base de datos**: MySQL 8.x
* **Capa de persistencia**: Spring Data JPA / Hibernate
* **Seguridad**: Spring Security + JJWT (tokens Bearer, arquitectura Stateless y contraseñas con BCrypt)
* **Validación**: Jakarta Bean Validation
* **Documentación de API**: SpringDoc OpenAPI 3 / Swagger UI

---

## 4. Arquitectura y Paquetes
El proyecto implementa una arquitectura por capas desacoplada bajo el paquete base `com.veterinaria.vetturno`:
* `model`: Entidades JPA (`Propietario`, `Mascota`, `Veterinario`, `Cita`, `Usuario`, `Rol`).
* `repository`: Interfaces de acceso a datos derivadas de `JpaRepository`.
* `service`: Lógica del negocio, resolución de llaves foráneas y reglas de validación de agenda.
* `controller`: Controladores REST que exponen los endpoints y manejan códigos HTTP intencionales (200, 201).
* `dto`: Objetos de transferencia de datos planos (`Request` y `DTO`) para evitar recursión cíclica JSON.
* `security`: Configuración de filtros (`JwtAuthFilter`), generación/validación de tokens (`JwtService`), carga de usuarios (`UsuarioDetailsService`) y reglas de seguridad (`SecurityConfig`).
* `config`: Configuración de OpenAPI y esquema de seguridad para Swagger UI.
* `exception`: Formato estándar de errores (`ApiError`) y manejador centralizado (`GlobalExceptionHandler`).

---

## 5. Configuración y Ejecución Local

### Prerrequisitos
* Java 17 instalado (`java -version`).
* MySQL Server en ejecución.

### Pasos de instalación
1. Clonar el repositorio:
   ```bash
   git clone <URL_DE_TU_REPOSITORIO>
   cd vetturno


   CREATE DATABASE vetturno;

Compilar y empaquetar el proyecto:

En Windows: .\mvnw.cmd clean package -DskipTests

Ejecutar la aplicación:

En Windows: .\mvnw.cmd spring-boot:run

acceder a Swagger UI:

Abrir en el navegador: http://localhost:8080/swagger-ui/index.html


Método,Endpoint,Acceso Requerido,Descripción,Código Exitoso
POST,/api/auth/register,Público,Registra usuario con rol USER y entrega token JWT,200 OK
POST,/api/auth/login,Público,Autentica credenciales y entrega token JWT vigente,200 OK
POST,/api/propietarios,USER / ADMIN,Registra un nuevo responsable,201 Created
GET,/api/propietarios,USER / ADMIN,Lista todos los propietarios,200 OK
POST,/api/mascotas,USER / ADMIN,Registra una mascota asociada a un propietario,201 Created
GET,/api/mascotas,USER / ADMIN,Lista mascotas con datos planos del propietario,200 OK
POST,/api/veterinarios,Solo ADMIN,Registra un nuevo profesional veterinario,201 Created (USER recibe 403)
GET,/api/veterinarios,USER / ADMIN,Lista los veterinarios disponibles,200 OK
POST,/api/citas,USER / ADMIN,Agenda una cita médica sin cruce de horario,201 Created
GET,/api/citas,USER / ADMIN,Devuelve la agenda clínica completa,200 OK
GET,/api/citas/veterinario/{id},USER / ADMIN,Filtra citas por veterinario,200 OK


#,Escenario,Entrada / Acción,Resultado Esperado y Obtenido,Estado HTTP
1,Inicio con MySQL,Ejecución de VetturnoApplication,Servidor iniciado en puerto 8080 y tablas creadas,200
2,Registro válido de Paula,POST /api/auth/register con email y password,"Usuario guardado con rol USER, hash BCrypt y token retornado",200 OK
3,Registro con datos inválidos,POST /api/auth/register con email inválido y clave corta,ApiError con lista detallada de errores por campo,400 Bad Request
4,Login con credenciales válidas,POST /api/auth/login con credenciales de Paula,Autenticación exitosa y JWT vigente retornado,200 OK
5,Consulta sin autenticación,GET /api/citas sin cabecera Authorization,Petición bloqueada por filtro de seguridad,403 Forbidden
6,Creación veterinario con USER,POST /api/veterinarios con token de Paula (USER),Acceso denegado por falta de privilegios administrativos,403 Forbidden
7,Creación veterinario con ADMIN,POST /api/veterinarios con token de Doña Marta (ADMIN),Veterinario creado y persistido exitosamente,201 Created
8,Creación válida de propietario,"POST /api/propietarios con nombre, teléfono y email",Propietario creado con ID generado en base de datos,201 Created
9,Creación mascota con propietario,POST /api/mascotas con propietarioId existente,Mascota creada y relacionada correctamente,201 Created
10,Mascota con propietario inexistente,POST /api/mascotas con propietarioId inexistente,ApiError controlado indicando que el propietario no existe,400 Bad Request
11,Cita futura con referencias válidas,"POST /api/citas con fecha futura, mascota y veterinario",Cita agendada y persistida en base de datos,201 Created
12,Cita con fecha en el pasado,POST /api/citas con fecha anterior a la actual,Rechazada con mensaje indicando que la fecha debe ser futura,400 Bad Request
13,Cita duplicada (mismo horario y veterinario),Segundo POST /api/citas en idéntica fecha/hora,Rechazada por cruce de horario del veterinario,400 Bad Request
14,Filtrado de citas por veterinario,GET /api/citas/veterinario/1,Lista únicamente las citas del profesional indicado,200 OK
15,Reinicio y prueba en Swagger,Reinicio de servidor y consulta con botón Authorize,Persistencia confirmada y flujo funcional,200 OK

crear JAR
.\mvnw.cmd package -DskipTests