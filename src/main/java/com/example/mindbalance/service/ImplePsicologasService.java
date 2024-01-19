package com.example.mindbalance.service;

import com.example.mindbalance.entity.Psicologas;
import com.example.mindbalance.repository.PsicologasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImplePsicologasService implements PsicologasService{

    private PsicologasRepository psicologasRepository;

    @Override
    public Psicologas createPsicologas(Psicologas psicologas) {
        return psicologasRepository.save(psicologas);
    }

    @Override
    public Psicologas getPsicologasById(String PsicologasId) {
        Optional<Psicologas> optionalPsicologas = psicologasRepository.findById(PsicologasId);
        return optionalPsicologas.get();
    }

    @Override
    public List<Psicologas> getAllPsicologas() {
        return psicologasRepository.findAll();
    }

    @Override
    public Psicologas updatePsicologas(Psicologas psicologas) {
        Psicologas existingPsicologas = psicologasRepository.findById(psicologas.getIdentificacion()).get();
        existingPsicologas.setNombre(psicologas.getNombre());
        existingPsicologas.setContacto(psicologas.getContacto());
        existingPsicologas.setCorreo(psicologas.getCorreo());
        Psicologas updatePsicologas = psicologasRepository.save(existingPsicologas);
        return updatePsicologas;
    }

    @Override
    public void deletePsicologas(String PsicologasId) {
        psicologasRepository.deleteById(PsicologasId);
    }
}
