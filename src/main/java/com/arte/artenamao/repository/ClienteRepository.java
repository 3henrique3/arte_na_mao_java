package com.arte.artenamao.repository;

import com.arte.artenamao.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {
}
