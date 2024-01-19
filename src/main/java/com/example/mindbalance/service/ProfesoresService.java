package com.example.mindbalance.service;

import com.example.mindbalance.entity.Profesores;

import java.util.List;

public interface ProfesoresService {
    Profesores createProfesores(Profesores profesores);

    Profesores getProfesoresById (String ProfesoresId);

    List<Profesores> getAllProfesores();

    Profesores updateProfesores(Profesores profesores);

    void deleteProfesores (String ProfesoresId);
}
