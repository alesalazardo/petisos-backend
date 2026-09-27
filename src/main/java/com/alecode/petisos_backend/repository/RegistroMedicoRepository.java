package com.alecode.petisos_backend.repository;

// IMPORTACIONES DE CLASES
import com.alecode.petisos_backend.model.RegistroMedico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface RegistroMedicoRepository extends JpaRepository<RegistroMedico, Long> {
    List<RegistroMedico> findByMascotaId(Long mascotaId);
}
