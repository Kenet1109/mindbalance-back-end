package com.example.mindbalance.service;

import com.example.mindbalance.entity.Grados;

import java.util.List;

public interface GradosService {
    Grados createGrados(Grados grados);

    Grados getGradosById (Long GradosId);

    List<Grados> getAllGrados();

    Grados updateGrados(Grados grados);

    void deleteGrados (Long GradosId);
}
