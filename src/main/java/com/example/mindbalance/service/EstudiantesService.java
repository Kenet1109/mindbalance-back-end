package com.example.mindbalance.service;

import com.example.mindbalance.entity.Estudiantes;

import java.util.List;

public interface EstudiantesService {

    Estudiantes createEstudiantes(Estudiantes estudiantes);

    Estudiantes getEstudiantesById (String EstudiantesId);

    List<Estudiantes> getAllEstudiantes();

    Estudiantes updateEstudiantes(Estudiantes estudiantes);

    void deleteEstudiantes (String EstudianteId);
}
