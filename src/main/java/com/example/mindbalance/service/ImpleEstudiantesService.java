package com.example.mindbalance.service;

import com.example.mindbalance.entity.Estudiantes;
import com.example.mindbalance.repository.EstudiantesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImpleEstudiantesService implements  EstudiantesService{

    private EstudiantesRepository estudiantesRepository;

    @Override
    public Estudiantes createEstudiantes(Estudiantes estudiantes) {
        return estudiantesRepository.save(estudiantes);
    }

    @Override
    public Estudiantes getEstudiantesById(String EstudiantesId) {
        Optional<Estudiantes> optionalEstudiantes = estudiantesRepository.findById(EstudiantesId);
        return optionalEstudiantes.get();
    }

    @Override
    public List<Estudiantes> getAllEstudiantes() {
        return estudiantesRepository.findAll();
    }

    @Override
    public Estudiantes updateEstudiantes(Estudiantes estudiantes) {
        Estudiantes existingEstudiantes = estudiantesRepository.findById(estudiantes.getIdentificacion()).get();
        existingEstudiantes.setNombre(estudiantes.getNombre());
        existingEstudiantes.setEdad(estudiantes.getEdad());
        existingEstudiantes.setGenero(estudiantes.getGenero());
        existingEstudiantes.setContacto(estudiantes.getContacto());
        existingEstudiantes.setCorreo(estudiantes.getCorreo());
        existingEstudiantes.setAcudiente(estudiantes.getAcudiente());
        existingEstudiantes.setGrado(estudiantes.getGrado());
        existingEstudiantes.setCurso(estudiantes.getCurso());
        Estudiantes updateEstudiantes = estudiantesRepository.save(existingEstudiantes);
        return updateEstudiantes;
    }

    @Override
    public void deleteEstudiantes(String EstudianteId) {
        estudiantesRepository.deleteById(EstudianteId);
    }
}
