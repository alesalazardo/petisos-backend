package com.alecode.petisos_backend.repository;

import com.alecode.petisos_backend.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    List<Tutor> findByNombreContainingIgnoreCase(String nombre);
    
}
