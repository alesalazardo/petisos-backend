package com.alecode.petisos_backend.controller;

import com.alecode.petisos_backend.model.Tutor;
import com.alecode.petisos_backend.repository.TutorRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
