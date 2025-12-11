package com.arte.artenamao.repository;

import com.arte.artenamao.model.ArtistaModel;
import com.arte.artenamao.model.CompraModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ArtistaRepository extends JpaRepository<ArtistaModel, UUID> {
    Optional<ArtistaModel> findById(UUID id);
}
