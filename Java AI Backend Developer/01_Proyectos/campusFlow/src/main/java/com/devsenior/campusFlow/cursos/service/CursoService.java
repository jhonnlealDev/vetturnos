package com.devsenior.campusFlow.cursos.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsenior.campusFlow.common.exception.ResourceNotFoundException;
import com.devsenior.campusFlow.cursos.model.Curso;
import com.devsenior.campusFlow.cursos.repository.CursoRepository;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    // Inyección por constructor
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Transactional(readOnly = true)
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Curso obtenerPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso", "id", id));
    }

    @Transactional
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public Curso actualizar(Long id, Curso cursoDetalles) {
        Curso curso = obtenerPorId(id);
        curso.setNombre(cursoDetalles.getNombre());
        curso.setDescripcion(cursoDetalles.getDescripcion());
        return cursoRepository.save(curso);
    }

    @Transactional
    public void eliminar(Long id) {
        Curso curso = obtenerPorId(id);
        cursoRepository.delete(curso);
    }
}
