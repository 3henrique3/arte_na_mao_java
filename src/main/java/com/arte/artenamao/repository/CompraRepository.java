package com.arte.artenamao.repository;

import com.arte.artenamao.model.CompraModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompraRepository extends JpaRepository<CompraModel, UUID> {
    Optional<CompraModel> findById(UUID compraId);
}
