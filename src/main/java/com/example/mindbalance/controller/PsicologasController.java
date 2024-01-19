package com.example.mindbalance.controller;

import com.example.mindbalance.entity.Psicologas;
import com.example.mindbalance.service.PsicologasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PsicologasController {

    private PsicologasService psicologasService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("psicologas")
    public ResponseEntity<Psicologas> createPsicologas (@RequestBody Psicologas psicologas){
        Psicologas savePsicologas = psicologasService.createPsicologas(psicologas);
        return new ResponseEntity<>(savePsicologas, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("psicologas/{id}")
    public ResponseEntity<Psicologas> psicologasById (@PathVariable("id") String psicologasId){
        Psicologas getPsicologas = psicologasService.getPsicologasById(psicologasId);
        return new ResponseEntity<>(getPsicologas, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("psicologas")
    public ResponseEntity<List<Psicologas>> getAllPsicologas (){
        List<Psicologas> psicologas = psicologasService.getAllPsicologas();
        return new ResponseEntity<>(psicologas, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("psicologas/{id}")
    public ResponseEntity<Psicologas> updatePsicologas (@PathVariable("id") String psicologasId, @RequestBody Psicologas psicologas){
        psicologas.setIdentificacion(psicologasId);
        Psicologas updatePsicologas = psicologasService.updatePsicologas(psicologas);
        return new ResponseEntity<>(updatePsicologas, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("psicologas/{id}")
    public ResponseEntity<String> deletePsicologas (@PathVariable("id") String psicologasId){
        psicologasService.deletePsicologas(psicologasId);
        return new ResponseEntity<>("Psicologas Sucessfull Delete!", HttpStatus.OK);
    }
}
