package com.example.mindbalance.controller;

import com.example.mindbalance.entity.Grados;
import com.example.mindbalance.service.GradosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class GradosController {

    private GradosService gradosService;

    @PostMapping("grados")
    public ResponseEntity<Grados> createGrados (@RequestBody Grados grados){
        Grados saveGrados = gradosService.createGrados(grados);
        return new ResponseEntity<>(saveGrados, HttpStatus.CREATED);
    }

    @GetMapping("grados/{id}")
    public ResponseEntity<Grados> gradosById (@PathVariable("id") Long gradosId){
        Grados grados = gradosService.getGradosById(gradosId);
        return new ResponseEntity<>(grados, HttpStatus.OK);
    }

    @GetMapping("grados")
    public ResponseEntity<List<Grados>> getAllGrados(){
        List<Grados> grados = gradosService.getAllGrados();
        return new ResponseEntity<>(grados, HttpStatus.OK);
    }

    @PutMapping("grados/{id}")
    public ResponseEntity<Grados> updateGrados (@PathVariable("id") long gradosId, @RequestBody Grados grados) {
        grados.setId(gradosId);
        Grados updateGrados = gradosService.updateGrados(grados);
        return new ResponseEntity<>( updateGrados, HttpStatus.OK);
    }

    @DeleteMapping("grados/{id}")
    public ResponseEntity<String> deleteGrados (@PathVariable("id") Long gradosId){
        gradosService.deleteGrados(gradosId);
        return new ResponseEntity<>("Grados Sucessfull Delete!", HttpStatus.OK);
    }

}
