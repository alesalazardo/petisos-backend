package com.alecode.petisos_backend.controller;

// IMPORTACIONES DE CLASES
import com.alecode.petisos_backend.model.RegistroMedico;
import com.alecode.petisos_backend.repository.RegistroMedicoRepository;

import jakarta.validation.Valid;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// ANOTACIONES DE LA CLASE CONTROLADOR
@RestController
@RequestMapping("/api/registros-medicos")
@CrossOrigin(origins = "*")
public class RegistroMedicoController {
    private final RegistroMedicoRepository registroMedicoRepository;

    public RegistroMedicoController(RegistroMedicoRepository registroMedicoRepository) {
        this.registroMedicoRepository = registroMedicoRepository;
    }

    @GetMapping
    public List<RegistroMedico> getAllRegistrosMedicos() {
        return registroMedicoRepository.findAll();
    }

    @SuppressWarnings("null")
    @PostMapping
    public RegistroMedico createRegistroMedico(@Valid @RequestBody RegistroMedico registroMedico) {
        return registroMedicoRepository.save(registroMedico);
    }

    @SuppressWarnings("null")
    @PutMapping("/{id}")
    public ResponseEntity<RegistroMedico> updateRegistroMedico(@PathVariable Long id, @RequestBody RegistroMedico registroMedicoDetails) {
        return registroMedicoRepository.findById(id)
            .map(existentRegistro -> {
                existentRegistro.setCategoria(registroMedicoDetails.getCategoria());
                existentRegistro.setDescripcion(registroMedicoDetails.getDescripcion());
                existentRegistro.setValorKilogramos(registroMedicoDetails.getValorKilogramos());
                existentRegistro.setFechaNacimiento(registroMedicoDetails.getFechaNacimiento());
                existentRegistro.setMascota(registroMedicoDetails.getMascota());
                RegistroMedico updatedRegistro = registroMedicoRepository.save(existentRegistro);
                return ResponseEntity.ok(updatedRegistro);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // @SuppressWarnings("null")
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteRegistroMedico(@PathVariable Long id) {
    //     return registroMedicoRepository.findById(id)
    //         .map(registro -> {
    //             registroMedicoRepository.delete(registro);
    //             return ResponseEntity.noContent()<void>.build();
    //         })
    //         .orElse(ResponseEntity.notFound().build());
    // }
}
