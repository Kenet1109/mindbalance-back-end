package com.example.mindbalance.controller;

import com.example.mindbalance.entity.Padres;
import com.example.mindbalance.entity.Psicologas;
import com.example.mindbalance.service.PadresService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PadresController {

    private PadresService padresService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("padres")
    public ResponseEntity<Padres> createPadres (@RequestBody Padres padres){
        Padres savePadres = padresService.createPadres(padres);
        return new ResponseEntity<>(savePadres, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("padres")
    public ResponseEntity<List<Padres>> getAllPadres (){
        List<Padres> padres = padresService.getAllPadres();
        return new ResponseEntity<>(padres, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("padres/{id}")
    public ResponseEntity<Padres> psicologasById (@PathVariable("id") String padresId){
        Padres getPadres = padresService.getPadresById(padresId);
        return new ResponseEntity<>(getPadres, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("padres/{id}")
    public ResponseEntity<Padres> updatePadres (@PathVariable("id") String padresId, @RequestBody Padres padres){
        padres.setIdentificacion(padresId);
        Padres updatePadres = padresService.updatePadres(padres);
        return new ResponseEntity<>(updatePadres, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("padres/{id}")
    public ResponseEntity<String> deletePadres (@PathVariable("id") String padresId){
        padresService.deletePadres(padresId);
        return new ResponseEntity<>("Padres Sucessfully Delete!", HttpStatus.OK);
    }
}
