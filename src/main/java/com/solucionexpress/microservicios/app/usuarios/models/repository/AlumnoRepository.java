package com.solucionexpress.microservicios.app.usuarios.models.repository;

import com.solucionexpress.microservicios.commons.alumnos.models.entity.Alumno;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository <Alumno,Long>{
	
	@Query("select a from Alumno a where a.nombre like %?1% or a.apellido like %?1%")
	public List<Alumno>findByNombreOrApellido(String term);
}
