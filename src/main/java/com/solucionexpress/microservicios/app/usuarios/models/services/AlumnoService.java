package com.solucionexpress.microservicios.app.usuarios.models.services;

import com.solucionexpress.microservicios.app.usuarios.models.entity.Alumno;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface AlumnoService {

    public Iterable<Alumno> findAll();

    public Optional<Alumno> findById(Long id);

    public Alumno save( Alumno alumno);

    public void deleteById  (Long id);
    
}
