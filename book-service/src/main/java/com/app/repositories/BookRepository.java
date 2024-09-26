package com.app.repositories;

import com.app.entities.CambioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<CambioEntity,Long> {
}
