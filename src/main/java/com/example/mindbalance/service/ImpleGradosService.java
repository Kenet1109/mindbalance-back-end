package com.example.mindbalance.service;

import com.example.mindbalance.entity.Grados;
import com.example.mindbalance.repository.GradosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImpleGradosService implements  GradosService{

    private GradosRepository gradosRepository;

    @Override
    public Grados createGrados(Grados grados) {
        return gradosRepository.save(grados);
    }

    @Override
    public Grados getGradosById(Long GradosId) {
        Optional<Grados> optionalGrados = gradosRepository.findById(GradosId);
        return optionalGrados.get();
    }

    @Override
    public List<Grados> getAllGrados() {
        return gradosRepository.findAll();
    }

    @Override
    public Grados updateGrados(Grados grados) {
        Grados existingGrados = gradosRepository.findById(grados.getId()).get();
        existingGrados.setGrado(grados.getGrado());
        existingGrados.setCurso(grados.getCurso());
        existingGrados.setProfesor(grados.getProfesor());
        Grados updateGrados = gradosRepository.save(existingGrados);
        return updateGrados;
    }

    @Override
    public void deleteGrados(Long GradosId) {
        gradosRepository.deleteById(GradosId);
    }
}
