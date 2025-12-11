package com.arte.artenamao.repository;

import com.arte.artenamao.model.ObraModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ObraRepository extends JpaRepository<ObraModel, UUID> {
}
