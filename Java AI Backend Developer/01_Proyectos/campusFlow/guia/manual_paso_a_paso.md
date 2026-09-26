# Manual Paso a Paso: Guía para Construir Proyectos Spring Boot desde Cero (CampusFlow)

Esta guía paso a paso está diseñada para acompañar tu proceso de aprendizaje de **Java** y **Spring Boot**. Aquí aprenderás no solo la sintaxis del código, sino el **porqué** y el **cuándo** se debe crear cada carpeta, interfaz, clase y anotación.

---

## 📌 Índice de Contenidos
1. [Estructura del Proyecto y Configuración de Maven](#1-estructura-del-proyecto-y-configuración-de-maven)
2. [Configuración de Propiedades (`application.properties`)](#2-configuración-de-propiedades-applicationproperties)
3. [Arquitectura por Dominios de Negocio](#3-arquitectura-por-dominios-de-negocio)
4. [Capa 1: Modelo / Entidad JPA (`model`)](#4-capa-1-modelo--entidad-jpa-model)
5. [Capa 2: Repositorio de Datos (`repository`)](#5-capa-2-repositorio-de-datos-repository)
6. [Capa 3: Servicio y Lógica de Negocio (`service`)](#6-capa-3-servicio-y-lógica-de-negocio-service)
7. [Capa 4: Controlador REST y API (`controller`)](#7-capa-4-controlador-rest-y-api-controller)
8. [Manejo Centralizado de Excepciones (`common.exception`)](#8-manejo-centralizado-de-excepciones-commonexception)
9. [Tips e Importantes Buenas Prácticas de Desarrollo](#9-tips-e-importantes-buenas-prácticas-de-desarrollo)

---

## 1. Estructura del Proyecto y Configuración de Maven

### ¿Qué es Maven y el archivo `pom.xml`?
Al crear un proyecto Java con Spring Boot, Maven gestiona las **dependencias** (librerías externas como JPA, MySQL, Spring Web).

- **`groupId`**: Representa la organización o paquete base del proyecto (ej: `com.devsenior`).
- **`artifactId`**: Es el nombre del proyecto o módulo (ej: `campusFlow`).
- **`dependencies`**: Lista de librerías que tu proyecto necesita para funcionar.

### Cuándo configurar `pom.xml`:
Se configura al iniciar el proyecto para agregar starters como:
- `spring-boot-starter-webmvc`: Para crear APIs REST.
- `spring-boot-starter-data-jpa`: Para conectarse a base de datos mediante Hibernate/JPA.
- `mysql-connector-j`: El driver que permite conectar Java con MySQL.

---

## 2. Configuración de Propiedades (`application.properties`)

### ¿Para qué sirve?
Es el archivo donde se le indica a Spring Boot cómo conectarse a la base de datos, qué puerto usar (`server.port=8080`), nivel de logs y comportamiento de Hibernate.

### Buenas prácticas aprendidas:
1. **Variables de entorno con Fallbacks por defecto**:
   - Sintaxis: `${NOMBRE_VARIABLE:valor_por_defecto}`
   - Ejemplo: `spring.datasource.url=${DB_URL:jdbc:mysql://localhost:3306/campus}`
   - **Ventaja**: Permite que el proyecto funcione en tu computadora de desarrollo sin configurar nada extra, pero si en el servidor se define la variable `DB_URL`, se usará el valor del servidor sin modificar el código.

---

## 3. Arquitectura por Dominios de Negocio

En lugar de poner todas las entidades en una carpeta global `entities` y todos los controladores en `controllers`, organizamos el proyecto **por Dominio de Negocio** (por ejemplo: `usuarios`, `cursos`, `pagos`).

### Estructura de carpetas recomendada:
```text
src/main/java/com/devsenior/campusFlow/
├── CampusFlowApplication.java (Clase principal)
├── common/ (Recursos compartidos como excepciones globales)
│   └── exception/
├── usuarios/ (Dominio de Usuarios)
│   ├── dto/ (Objetos de Transferencia de Datos y Request/Response)
│   ├── mapper/ (Mapeadores de Conversión entre DTOs y Entidades)
│   ├── model/ (Entidades JPA)
│   ├── repository/ (Interfaces de base de datos)
│   ├── service/ (Lógica de negocio)
│   └── controller/ (Endpoints HTTP REST)
└── cursos/ (Dominio de Cursos)
    ├── model/
    ├── repository/
    ├── service/
    └── controller/
```

### Regla de oro de los paquetes Java:
> **Importante**: La declaración `package com.devsenior.campusFlow.usuarios.model;` debe coincidir exactamente en mayúsculas y minúsculas con la estructura de carpetas física en el disco duro para evitar errores de compilación en el IDE.

---

## 4. Capa 1: Modelo / Entidad JPA (`model`)

### ¿Cuándo crear una clase `@Entity`, `@Embeddable` o un `enum`?
- **`@Entity`**: Se crea cuando deseas representar una **tabla principal en la base de datos** (ej: `Usuario`).
- **`enum`**: Define un conjunto fijo de constantes (ej: roles de usuario `RolUsuario` o temas de la interfaz `TemaVisual`).
- **`@Embeddable`**: Permite agrupar atributos relacionales en una clase Java reutilizable que se incrusta dentro de una entidad principal sin crear una tabla separada.

### Ejemplos en el dominio de usuarios (`usuarios/model`):

#### Enums: `RolUsuario.java` y `TemaVisual.java`
```java
package com.devsenior.campusFlow.usuarios.model;

public enum RolUsuario {
    ESTUDIANTE,
    INSTRUCTOR,
    ADMINISTRADOR
}
```

```java
package com.devsenior.campusFlow.usuarios.model;

public enum TemaVisual {
    CLARO,
    OSCURO
}
```

#### Objeto Incrustable (`@Embeddable`): `PreferenciasUsuario.java`
```java
package com.devsenior.campusFlow.usuarios.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class PreferenciasUsuario {

    @Enumerated(EnumType.STRING) // Guarda el nombre del enum como texto (ej: "CLARO") en lugar de un índice numérico
    private TemaVisual tema = TemaVisual.CLARO;

    private boolean notificacionesActivas = true;

    public TemaVisual getTema() {
        return tema;
    }

    public void setTema(TemaVisual tema) {
        this.tema = tema;
    }

    public boolean isNotificacionesActivas() {
        return notificacionesActivas;
    }

    public void setNotificacionesActivas(boolean notificacionesActivas) {
        this.notificacionesActivas = notificacionesActivas;
    }
}
```

#### Entidad Principal (`Usuario.java`):
```java
package com.devsenior.campusFlow.usuarios.model;

import java.util.ArrayList;
import java.util.List;

import com.devsenior.campusFlow.cursos.model.Curso;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private RolUsuario rol;

    @Embedded
    private PreferenciasUsuario preferencias = new PreferenciasUsuario();

    @OneToMany(mappedBy = "instructor")
    private List<Curso> cursosDictados = new ArrayList<>();

    @ManyToMany(mappedBy = "estudiantes")
    private List<Curso> cursosInscritos = new ArrayList<>();

    // Getters y Setters
}
```

#### Entidad Principal (`Curso.java`):
Representa el lado propietario de las relaciones bidireccionales con `Usuario`:
- **`@ManyToOne` con `@JoinColumn`**: Define la relación con el instructor (muchos cursos pertenecen a un instructor).
- **`@ManyToMany` con `@JoinTable`**: Define la relación de inscripciones entre cursos y estudiantes (crea la tabla intermedia `curso_estudiante`).

```java
package com.devsenior.campusFlow.cursos.model;

import java.util.ArrayList;
import java.util.List;
import com.devsenior.campusFlow.usuarios.model.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Usuario instructor;

    @ManyToMany
    @JoinTable(
        name = "curso_estudiante",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    private List<Usuario> estudiantes = new ArrayList<>();

    // Constructores, Getters y Setters
}
```

### ¿Cuándo y por qué usar DTOs (`dto`)?
Los **DTO (Data Transfer Objects)** son clases que se utilizan exclusivamente para transferir datos entre capas (por ejemplo, de las solicitudes HTTP entrantes del cliente hacia la aplicación).

- **¿Por qué no usar las entidades JPA directamente en los controladores?**
  1. **Seguridad**: Evita exponer campos sensibles (como contraseñas o datos internos) o la inyección directa de campos no autorizados (Over-posting attack).
  2. **Desacoplamiento**: Permite modificar la estructura de la base de datos sin romper las APIs públicas que consumen los clientes.
  3. **Validación**: Permite aplicar reglas de validaciones específicas del request con annotations como `@NotBlank`, `@Email`, `@NotNull`.

#### Ejemplo de DTO Request (`CrearUsuarioRequest.java`):
```java
package com.devsenior.campusFlow.usuarios.dto;

import com.devsenior.campusFlow.usuarios.model.RolUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CrearUsuarioRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe tener un formato válido")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    @NotNull(message = "El rol es obligatorio")
    private RolUsuario rol;

    // Constructores, Getters y Setters
}
```

#### Ejemplo de DTO de Actualización (`ActualizarUsuarioRequest.java`):
```java
package com.devsenior.campusFlow.usuarios.dto;

import com.devsenior.campusFlow.usuarios.model.RolUsuario;
import com.devsenior.campusFlow.usuarios.model.TemaVisual;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ActualizarUsuarioRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "El email debe tener un formato válido")
    private String email;

    private RolUsuario rol;

    private TemaVisual tema;

    private Boolean notificacionesActivas;

    // Constructores, Getters y Setters
}
```

#### Ejemplo de DTO Response (`UsuarioResponse.java`):
```java
package com.devsenior.campusFlow.usuarios.dto;

import com.devsenior.campusFlow.usuarios.model.RolUsuario;
import com.devsenior.campusFlow.usuarios.model.TemaVisual;
import com.devsenior.campusFlow.usuarios.model.Usuario;

public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String email;
    private RolUsuario rol;
    private TemaVisual tema;
    private Boolean notificacionesActivas;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Usuario usuario) {
        if (usuario != null) {
            this.id = usuario.getId();
            this.nombre = usuario.getNombre();
            this.email = usuario.getEmail();
            this.rol = usuario.getRol();
            if (usuario.getPreferencias() != null) {
                this.tema = usuario.getPreferencias().getTema();
                this.notificacionesActivas = usuario.getPreferencias().isNotificacionesActivas();
            }
        }
    }

    // Getters y Setters
}
```

---

## 5. Capa 2: Repositorio de Datos (`repository`)

### ¿Cuándo crear una `Interface` en lugar de una `Class`?
En Spring Data JPA, **no escribes las consultas SQL manualmente**. Creas una **interfaz** que hereda de `JpaRepository<Entidad, TipoID>`. Spring genera automáticamente la implementación por ti en tiempo de ejecución.

### Ejemplo (`UsuarioRepository.java`):
```java
package com.devsenior.campusFlow.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devsenior.campusFlow.usuarios.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Hereda métodos listos para usar:
    // .findAll(), .findById(), .save(), .delete()
}
```

---

## 6. Capa 3: Servicio y Lógica de Negocio (`service`)

### ¿Por qué NO llamar al repositorio directamente desde el controlador?
El controlador solo debe encargarse de recibir peticiones HTTP y devolver respuestas. Toda la lógica de negocio (validaciones, transacciones, reglas de negocio) debe vivir en la capa de **Servicio**.

### Inyección por Constructor (`private final`):
En Spring Boot moderno, en lugar de usar `@Autowired` sobre atributos, se declara el atributo como `private final` y se inicializa en el constructor.

### Ejemplo (`UsuarioService.java`):
```java
package com.devsenior.campusFlow.usuarios.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsenior.campusFlow.common.exception.ResourceNotFoundException;
import com.devsenior.campusFlow.usuarios.model.Usuario;
import com.devsenior.campusFlow.usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Inyección por constructor (Buenas prácticas)
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true) // Optimiza consultas de solo lectura
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));
    }

    @Transactional // Inicia transacción de base de datos
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
```

---

## 7. Capa 4: Controlador REST y API (`controller`)

### ¿Para qué sirve un `@RestController`?
Se encarga de exponer los endpoints HTTP para que aplicaciones externas (como frontend en React, Angular, Postman o clientes móviles) puedan comunicarse con tu backend.

### Mapeo de Verbos HTTP:
- `@GetMapping`: Consultar datos (`200 OK`).
- `@PostMapping`: Crear un nuevo recurso (`201 Created`).
- `@PutMapping`: Actualizar un recurso existente (`200 OK`).
- `@DeleteMapping`: Eliminar un recurso (`204 No Content`).

### Ejemplo (`UsuarioController.java`):
```java
package com.devsenior.campusFlow.usuarios.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.devsenior.campusFlow.usuarios.model.Usuario;
import com.devsenior.campusFlow.usuarios.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios") // Ruta base de los endpoints
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario guardar(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }
}
```

---

## 8. Manejo Centralizado de Excepciones (`common.exception`)

### ¿Por qué usar `@RestControllerAdvice`?
Si un id no se encuentra, en lugar de retornar un error horriblemente formateado por defecto (pantalla blanca de Tomcat o error 500 desordenado), podemos capturar las excepciones globalmente y devolver una respuesta JSON limpia y uniforme.

1. **Excepción Personalizada** (`ResourceNotFoundException.java`):
   ```java
   @ResponseStatus(HttpStatus.NOT_FOUND)
   public class ResourceNotFoundException extends RuntimeException {
       public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
           super(String.format("%s no encontrado con %s: '%s'", resourceName, fieldName, fieldValue));
       }
   }
   ```
2. **Manejador Global** (`GlobalExceptionHandler.java`):
   Captura automáticamente `ResourceNotFoundException` y cualquier `Exception` no controlada, devolviendo un JSON estructurado con `timestamp`, `status`, `error` y `message`.

---

## 9. Tips e Importantes Buenas Prácticas de Desarrollo

1. **Siempre verifica que el código compile**:
   - Corre `.\mvnw.cmd compile` en la terminal antes de finalizar cualquier módulo.
2. **Usa tipos de datos Wrapper (`Long` en vez de `long`)**:
   - Para las IDs de las entidades JPA, utiliza la clase `Long` (objeto). Esto permite que el id sea `null` cuando un objeto aún no ha sido guardado en la base de datos.
3. **Inmutabilidad de servicios y controladores**:
   - Declara siempre las dependencias inyectadas con `private final`.
4. **Principios de Clean Code (Código Limpio)**:
   - Emplea nombres descriptivos y expresivos, mantiene métodos enfocados en una única responsabilidad (SRP), evita duplicar código (DRY) y elimina valores mágicos o código muerto/comentado.
5. **Glosario Interactivo**:
   - Consulta el archivo [glosario.html](file:///c:/Users/diaco/OneDrive/Documentos/001_Devsenior/Java%20AI%20Backend%20Developer/01_Proyectos/campusFlow/guia/glosario.html) para consultar las definiciones resumidas de cualquier término de Java o Spring Boot.
