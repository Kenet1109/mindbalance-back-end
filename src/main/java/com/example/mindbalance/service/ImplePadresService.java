package com.example.mindbalance.service;

import com.example.mindbalance.entity.Padres;
import com.example.mindbalance.entity.Psicologas;
import com.example.mindbalance.repository.PadresRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ImplePadresService implements PadresService{

    private PadresRespository padresRespository;

    @Override
    public Padres createPadres(Padres padres) {
        return padresRespository.save(padres);
    }

    @Override
    public Padres getPadresById(String PadresId) {
        Optional<Padres> optionalPadres = padresRespository.findById(PadresId);
        return optionalPadres.get();
    }

    @Override
    public List<Padres> getAllPadres() {
        return padresRespository.findAll();
    }

    @Override
    public Padres updatePadres(Padres padres) {
        Padres existingPadres = padresRespository.findById(padres.getIdentificacion()).get();
        existingPadres.setNombre(padres.getNombre());
        existingPadres.setContacto(padres.getContacto());
        existingPadres.setCorreo(padres.getCorreo());
        existingPadres.setAcudiente(padres.getAcudiente());
        Padres updatePadres = padresRespository.save(existingPadres);
        return updatePadres;
    }

    @Override
    public void deletePadres(String padresId) {
        padresRespository.deleteById(padresId);
    }
}
