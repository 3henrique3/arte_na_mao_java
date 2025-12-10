package com.arte.artenamao.repository;

import com.arte.artenamao.model.EventoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EventoRepository extends JpaRepository<EventoModel, UUID> {
    Optional<EventoModel> findById(UUID eventoId);

}
