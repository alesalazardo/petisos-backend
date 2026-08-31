package com.alecode.petisos_backend.controller;

// IMPORTACIONES DE CLASES
import com.alecode.petisos_backend.model.Tutor;
import com.alecode.petisos_backend.repository.TutorRepository;

// IMPORTACIONES DE ANOTACIONES
import org.springframework.web.bind.annotation.*;

// IMPORTACIONES DE CLASES DE JAVA
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
}
