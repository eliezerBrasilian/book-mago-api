package com.app.repositories;

import com.app.entities.CambioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CambioRepository extends MongoRepository<CambioEntity, String> {
    Optional<CambioEntity> findByFromAndTo(String from, String to);
}
