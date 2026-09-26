package com.devsenior.campusFlow.cursos.model;

import java.util.ArrayList;
import java.util.List;

import com.devsenior.campusFlow.usuarios.model.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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

    public Curso() {
    }

    public Curso(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Curso(Long id, String nombre, String descripcion, Usuario instructor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getInstructor() {
        return instructor;
    }

    public void setInstructor(Usuario instructor) {
        this.instructor = instructor;
    }

    public List<Usuario> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Usuario> estudiantes) {
        this.estudiantes = estudiantes;
    }
}

