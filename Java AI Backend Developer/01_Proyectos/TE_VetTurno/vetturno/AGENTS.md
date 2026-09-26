# Reglas y Guía de Desarrollo para el Agente (VetTurno)

Este archivo contiene las directivas, reglas y estándares que el agente de IA debe seguir al trabajar en el proyecto **VetTurno**.

---

## 🏗️ 1. Arquitectura, Estructura de Clases y Principios SOLID
- **Lenguaje / Framework**: Java 17+ / Spring Boot.
- **Patrón de Arquitectura**: Arquitectura en capas bien desacoplada (`Controller` -> `Service` -> `Repository` -> `Entity/DTO`).
- **Principios SOLID**:
  - **Single Responsibility Principle (SRP)**: Cada clase, método, interfaz o enum debe tener una sola responsabilidad bien definida.
  - **Inyección de Dependencias**: Preferir la inyección por constructor sobre `@Autowired` en atributos.
  - **Separación DTO / Entidad**: No exponer las entidades JPA directamente en las respuestas HTTP; mapear a DTOs.

---

## 🏷️ 2. Naming (Convenciones de Nombres)
- **Expresivos y Reveladores**: Nombres explícitos que indiquen su intención sin abreviaciones ambiguas (usar `usuario` en vez de `usr`, `idTurno` en vez de `tId`).
- **Casos de Uso**:
  - Clases e Interfaces: `PascalCase` (ej. `MascotaService`, `TurnoController`).
  - Métodos y Variables: `camelCase` (ej. `obtenerTurnosPorVeterinario`, `idMascota`).
  - Constantes / Enums: `UPPER_SNAKE_CASE` (ej. `ESTADO_PENDIENTE`).
  - Paquetes: `lowercase` (`com.veterinaria.vetturno.services`).

---

## 🛡️ 3. Tratamiento de Valores Nulos y Optional
- **Retorno de Optional**: Usar `Optional<T>` en métodos de búsqueda que puedan no encontrar un registro en lugar de retornar `null`.
- **Prevención de NullPointerException**: Evitar pasar o retornar `null` directamente.
- **Validación de Entradas**: Usar Jakarta Bean Validation (`@NotNull`, `@NotBlank`, `@Size`) en DTOs para asegurar que los datos estén limpios desde el Controller.

---

## 🚨 4. Manejo Limpio de Excepciones
- **Excepciones de Negocio**: Crear excepciones explícitas y descriptivas de dominio (ej. `TurnoNoDisponibleException`, `MascotaNotFoundException`).
- **Manejo Centralizado**: Capturar y formatear las respuestas de error mediante un `@ControllerAdvice` global (`GlobalExceptionHandler`).
- **Sin Silenciar Errores**: Nunca usar bloques `try-catch` vacíos ni retornar booleanos o códigos de error opacos en la capa de servicio.

---

## 💬 5. Comentarios y Legibilidad (Regla de Encabezado Corto)
- **REGLA DE ENCABEZADO**: En la parte superior de cada archivo (clase, interfaz, enum o record), incluir **únicamente** un detalle conciso en primera persona indicando para qué sirve esa unidad y el flujo de los datos.
  - **Ejemplo**:
    ```java
    /*
     * Esta interfaz/clase se encarga de crear, leer, actualizar y eliminar las mascotas.
     * Los datos vienen desde el controller y van hacia el repositorio de mascotas.
     */
    ```
- **PROHIBIDO COMENTAR CÓDIGO LÍNEA POR LÍNEA**: No agregar comentarios explicativos bloque por bloque dentro de los métodos. El código debe ser lo suficientemente limpio y autoexplicativo por sí mismo.

---

## ⚙️ 6. Reglas del Agente de IA
- **Preservar Código Existente**: No eliminar funcionalidades existentes ni modificar firmas de métodos sin justificación previa.
- **Sin Valores 'Hardcoded'**: Utilizar `application.properties` / `application.yml` para configuraciones.
- **Verificación Obligatoria**: Antes de dar por finalizada una tarea, ejecutar la compilación (`mvn clean compile`) o las pruebas (`mvn test`).
