package com.solucionexpress.microservicios.app.usuarios.controllers;

import com.solucionexpress.microservicios.app.usuarios.models.entity.Alumno;
import com.solucionexpress.microservicios.app.usuarios.models.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {
    @Autowired
    private AlumnoService service;

    @GetMapping()
    public ResponseEntity<?> index (){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver (@PathVariable Long id){
        Optional<Alumno> alumno = service.findById(id);

        if( alumno.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( alumno.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno){
        Alumno alumnodb = service.save( alumno );

        return ResponseEntity.status(HttpStatus.CREATED).body( alumno );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno,@PathVariable Long id){
        Optional<Alumno> o = service.findById(id);
        if( o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Alumno alumnoDb = o.get();
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body( service.save(alumnoDb) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> eliminar(@PathVariable Long id ){
         service.deleteById(id);
         return ResponseEntity.noContent().build();
    }
}
