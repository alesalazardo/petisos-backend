package com.alecode.petisos_backend.repository;

// IMPORTACIONES DE CLASES
import com.alecode.petisos_backend.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// IMPORTACIONES DE CLASES DE JAVA
import java.util.List;

// @Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findByTutorId(Long tutorId);

}
