package com.alecode.petisos_backend.repository;

// IMPORTACIONES DE CLASES
import com.alecode.petisos_backend.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// IMPORTACIONES DE CLASES DE JAVA
import java.util.List;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    List<Tutor> findByNombreContainingIgnoreCase(String nombre);
    Optional<Tutor> findByEmail(String email);
}

