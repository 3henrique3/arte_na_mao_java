package com.arte.artenamao.repository;

import com.arte.artenamao.model.ClienteModel;
import com.arte.artenamao.model.CompraModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {
    Optional<ClienteModel> findById(UUID id);
}
