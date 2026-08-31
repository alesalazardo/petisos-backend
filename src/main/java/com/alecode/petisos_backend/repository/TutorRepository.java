package com.alecode.petisos_backend.repository;

// IMPORTACIONES DE CLASES
import com.alecode.petisos_backend.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

// IMPORTACIONES DE CLASES DE JAVA
import java.util.List;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    List<Tutor> findByNombreContainingIgnoreCase(String nombre);
    
}
