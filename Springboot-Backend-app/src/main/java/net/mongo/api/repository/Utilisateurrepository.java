package net.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.mongo.api.model.Utilisateur;;

public interface Utilisateurrepository extends MongoRepository<Utilisateur,String> {


}
