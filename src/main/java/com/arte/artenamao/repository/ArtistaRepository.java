package com.arte.artenamao.repository;

import com.arte.artenamao.model.ArtistaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArtistaRepository extends JpaRepository<ArtistaModel, UUID> {
}
