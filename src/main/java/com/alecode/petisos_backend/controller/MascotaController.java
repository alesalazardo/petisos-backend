package com.alecode.petisos_backend.controller;

// IMPORTACION DE CLASES DE LA ENTIDAD Y REPOSITORIO
import com.alecode.petisos_backend.model.Mascota;
import com.alecode.petisos_backend.repository.MascotaRepository;

import org.springframework.http.ResponseEntity;
// IMPORTACION DE ANOTACIONES
import org.springframework.web.bind.annotation.*;

// IMPORTACION DE CLASES DE JAVA
import java.util.List;

// ANOTACIONES DE LA CLASE CONTROLADOR
@RestController
@RequestMapping("/api/mascotas")
@CrossOrigin(origins = "*")
public class MascotaController {
    private final MascotaRepository mascotaRepository;

    public MascotaController(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @GetMapping
    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    @SuppressWarnings("null")
    @PostMapping
    public Mascota createMascota(@RequestBody Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @SuppressWarnings("null")
    @PutMapping("/{id}")
    public ResponseEntity<Mascota> updateMascota(@PathVariable Long id, @RequestBody Mascota mascotaDetails) {
        return mascotaRepository.findById(id)
            .map(existentMascota -> {
                existentMascota.setNombre(mascotaDetails.getNombre());
                existentMascota.setEspecie(mascotaDetails.getEspecie());
                existentMascota.setRaza(mascotaDetails.getRaza());
                existentMascota.setFechaNacimiento(mascotaDetails.getFechaNacimiento());
                existentMascota.setTutor(mascotaDetails.getTutor());
                existentMascota.setColor(mascotaDetails.getColor());
                existentMascota.setDescripcion(mascotaDetails.getDescripcion());
                Mascota updatedMascota = mascotaRepository.save(existentMascota);
                return ResponseEntity.ok(updatedMascota);
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
