package com.example.mindbalance.controller;


import com.example.mindbalance.entity.Profesores;
import com.example.mindbalance.service.ProfesoresService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ProseforesController {

    private ProfesoresService profesoresService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("profesores")
    public ResponseEntity<Profesores> createProfesores (@RequestBody Profesores profesores){
        Profesores saveProfesores = profesoresService.createProfesores(profesores);
        return new ResponseEntity<>(saveProfesores, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("profesores/{id}")
    public ResponseEntity<Profesores> profesoresByID (@PathVariable("id") String ProfesoresId){
        Profesores profesores = profesoresService.getProfesoresById(ProfesoresId);
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("profesores")
    public ResponseEntity<List<Profesores>> getAllProfesores (){
        List<Profesores> profesores = profesoresService.getAllProfesores();
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("profesores/{id}")
    public ResponseEntity<Profesores> updateProfesores (@PathVariable("id") String profesoresId, @RequestBody Profesores profesores){
        profesores.setIdentificacion(profesoresId);
        Profesores updateProfesores = profesoresService.updateProfesores(profesores);
        return new ResponseEntity<>(updateProfesores, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("profesores/{id}")
    public ResponseEntity<String> deleteProfesores (@PathVariable("id") String profesoresId){
        profesoresService.deleteProfesores(profesoresId);
        return new ResponseEntity<>("Profesores Sucessfull Delete!", HttpStatus.OK);
    }
}
