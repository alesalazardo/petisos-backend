package com.alecode.petisos_backend.controller;

import com.alecode.petisos_backend.dto.AuthResponse;
import com.alecode.petisos_backend.dto.LoginRequest;
import com.alecode.petisos_backend.model.Tutor;
import com.alecode.petisos_backend.repository.TutorRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class AuthController {

    private final TutorRepository tutorRepository;

    // Inyección por constructor (elimina la advertencia de @Autowired)
    public AuthController(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
       
        Optional<Tutor> tutorOptional = tutorRepository.findByEmail(loginRequest.getUsername());

        if (tutorOptional.isPresent()) {
            Tutor tutor = tutorOptional.get();

            if (tutor.getPassword() != null && tutor.getPassword().equals(loginRequest.getPassword())) {
                
                String userRole = "ale@mail.com".equalsIgnoreCase(tutor.getEmail()) ? "admin" : "tutor";
                
                return ResponseEntity.ok(new AuthResponse(
                    true, 
                    "Inicio de sesión exitoso", 
                    tutor.getEmail(), 
                    userRole
                ));
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new AuthResponse(false, "Credenciales inválidas", null, null));
    }
}