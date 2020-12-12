package com.solucionexpress.microservicios.app.usuarios.models.repository;

import com.solucionexpress.microservicios.commons.alumnos.models.entity.Alumno;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlumnoRepository extends PagingAndSortingRepository<Alumno,Long> {
	
	@Query("select a from Alumno a where upper(a.nombre) like upper(concat('%', ?1, '%')) or upper(a.apellido)  like upper(concat('%', ?1, '%'))")
	public List<Alumno>findByNombreOrApellido(String term);
	
	public Iterable<Alumno> findAllByOrderByIdAsc();
	
	public Page<Alumno> findAllByOrderByIdAsc(Pageable page);
	
}
