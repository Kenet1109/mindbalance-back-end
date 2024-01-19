package com.example.mindbalance.controller;

import com.example.mindbalance.entity.Estudiantes;
import com.example.mindbalance.service.EstudiantesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class EstudiantesController {

    private EstudiantesService estudiantesService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("estudiantes")
    public ResponseEntity<Estudiantes> createEstudiantes (@RequestBody Estudiantes estudiantes){
        Estudiantes saveEstudiantes = estudiantesService.createEstudiantes(estudiantes);
        return new ResponseEntity<>(saveEstudiantes, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("estudiantes/{id}")
    public ResponseEntity<Estudiantes> estudiantesById (@PathVariable("id") String estudiantesId){
        Estudiantes getEstudiantes = estudiantesService.getEstudiantesById(estudiantesId);
        return new ResponseEntity<>(getEstudiantes, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("estudiantes")
    public ResponseEntity<List<Estudiantes>> getAllEstudiantes (){
        List<Estudiantes> estudiantes = estudiantesService.getAllEstudiantes();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("estudiantes/{id}")
    public ResponseEntity<Estudiantes> updateEstudiantes (@PathVariable("id") String estudiantesId, @RequestBody Estudiantes estudiantes){
        estudiantes.setIdentificacion(estudiantesId);
        Estudiantes updateEstudiantes = estudiantesService.updateEstudiantes(estudiantes);
        return new ResponseEntity<>(updateEstudiantes, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("estudiantes/{id}")
    public ResponseEntity<String> deleteEstudiantes (@PathVariable("id") String estudiantesId){
        estudiantesService.deleteEstudiantes(estudiantesId);
        return new ResponseEntity<>("Estudiantes Sucessfull Delete!", HttpStatus.OK);
    }

}
