package com.ecomos.coreconfig.repository;

import com.ecomos.coreconfig.entities.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends MongoRepository<Property, String> {

    Property findByKey(String key);

}
