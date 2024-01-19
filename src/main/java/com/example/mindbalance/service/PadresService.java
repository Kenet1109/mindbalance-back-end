package com.example.mindbalance.service;

import com.example.mindbalance.entity.Padres;
import com.example.mindbalance.entity.Psicologas;

import java.util.List;

public interface PadresService {

    Padres createPadres(Padres padres);

    List<Padres> getAllPadres();

    Padres getPadresById (String PadresId);

    Padres updatePadres(Padres padres);

    void deletePadres(String padresId);
}
