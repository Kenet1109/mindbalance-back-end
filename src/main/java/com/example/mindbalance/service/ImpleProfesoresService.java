package com.example.mindbalance.service;

import com.example.mindbalance.entity.Profesores;
import com.example.mindbalance.repository.ProfesoresRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImpleProfesoresService implements ProfesoresService {

    private ProfesoresRepository profesoresRepository;
    @Override
    public Profesores createProfesores(Profesores profesores) {
        return profesoresRepository.save(profesores);
    }

    @Override
    public Profesores getProfesoresById(String ProfesoresId) {
        Optional<Profesores> optionalProfesores = profesoresRepository.findById(ProfesoresId);
        return optionalProfesores.get();
    }

    @Override
    public List<Profesores> getAllProfesores() {
        return profesoresRepository.findAll();
    }

    @Override
    public Profesores updateProfesores(Profesores profesores) {
        Profesores existingProfesores = profesoresRepository.findById(profesores.getIdentificacion()).get();
        existingProfesores.setNombre(profesores.getNombre());
        existingProfesores.setContacto(profesores.getContacto());
        existingProfesores.setCorreo(profesores.getCorreo());
        Profesores updateProfesores = profesoresRepository.save(existingProfesores);
        return updateProfesores;
    }

    @Override
    public void deleteProfesores(String ProfesoresId) {
        profesoresRepository.deleteById(ProfesoresId);
    }
}
