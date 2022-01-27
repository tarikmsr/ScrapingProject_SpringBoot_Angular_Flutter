package net.mongo.api.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import net.mongo.api.model.Dataset;

public interface DatasetRepository extends MongoRepository<Dataset,String> {

}