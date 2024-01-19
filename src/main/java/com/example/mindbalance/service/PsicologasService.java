package com.example.mindbalance.service;

import com.example.mindbalance.entity.Psicologas;

import java.util.List;

public interface PsicologasService {
    Psicologas createPsicologas(Psicologas psicologas);

    Psicologas getPsicologasById (String PsicologasId);

    List<Psicologas> getAllPsicologas();

    Psicologas updatePsicologas(Psicologas psicologas);

    void deletePsicologas (String PsicologasId);
}
