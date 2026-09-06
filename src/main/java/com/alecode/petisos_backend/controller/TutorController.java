package com.alecode.petisos_backend.controller;

// IMPORTACION DE CLASES
import com.alecode.petisos_backend.model.Tutor;
import com.alecode.petisos_backend.repository.TutorRepository;

import org.springframework.http.ResponseEntity;

// IMPORTACION DE ANOTACIONES
import org.springframework.web.bind.annotation.*;

// IMPORTACION DE CLASES DE JAVA
import java.util.List;

// ANOTACIONES DE LA CLASE
@RestController
@RequestMapping("/api/tutores")
@CrossOrigin(origins = "*")
public class TutorController {
    private final TutorRepository tutorRepository;

    public TutorController(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @GetMapping
    public List<Tutor> getAllTutores() {
        return tutorRepository.findAll();
    }

    @SuppressWarnings("null")
    @PostMapping
    public Tutor createTutor(@RequestBody Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @SuppressWarnings("null")
    @PutMapping("/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable Long id, @RequestBody Tutor tutorDetails) {
        return tutorRepository.findById(id)
            .map(existentTutor -> {
                existentTutor.setNombre(tutorDetails.getNombre());
                existentTutor.setApellido(tutorDetails.getApellido());
                existentTutor.setTelefono(tutorDetails.getTelefono());
                existentTutor.setEmail(tutorDetails.getEmail());
                existentTutor.setCiudad(tutorDetails.getCiudad());
                Tutor updatedTutor = tutorRepository.save(existentTutor);
                return ResponseEntity.ok(updatedTutor);
            })
            .orElse(ResponseEntity.notFound().build());
    } 

    @SuppressWarnings ("null")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id) {
        return tutorRepository.findById(id)
            .map(tutor -> {
                tutorRepository.delete(tutor);
                return ResponseEntity.noContent().<Void>build();
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
