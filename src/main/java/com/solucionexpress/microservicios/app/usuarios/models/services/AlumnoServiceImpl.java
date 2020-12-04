package com.solucionexpress.microservicios.app.usuarios.models.services;

import com.solucionexpress.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.solucionexpress.microservicios.commons.alumnos.models.entity.Alumno;
import com.solucionexpress.microservicios.commons.services.CommonServiceImpl;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno,AlumnoRepository> implements AlumnoService{

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {
		return repository.findByNombreOrApellido(term);
	}


}
