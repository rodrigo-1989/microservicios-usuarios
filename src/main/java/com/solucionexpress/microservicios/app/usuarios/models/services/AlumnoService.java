package com.solucionexpress.microservicios.app.usuarios.models.services;



import java.util.List;

import com.solucionexpress.microservicios.commons.alumnos.models.entity.Alumno;
import com.solucionexpress.microservicios.commons.services.CommonService;


public interface AlumnoService extends CommonService<Alumno>{

	public List<Alumno>findByNombreOrApellido(String term);
    
}
