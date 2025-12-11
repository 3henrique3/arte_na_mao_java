package com.arte.artenamao.repository;

import com.arte.artenamao.model.CompraModel;
import com.arte.artenamao.model.ObraModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ObraRepository extends JpaRepository<ObraModel, UUID> {
    Optional<ObraModel> findById(UUID id);
}
