package vn.mega.coreconfig.repository;

import vn.mega.coreconfig.entities.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends MongoRepository<Property, String> {

    Property findByKey(String key);

}
