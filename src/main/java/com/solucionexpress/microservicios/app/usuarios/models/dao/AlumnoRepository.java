package com.solucionexpress.microservicios.app.usuarios.models.dao;

import com.solucionexpress.microservicios.app.usuarios.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository <Alumno,Long>{
}
