package tn.esprit.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Societe;

@Repository
public interface ISocieteRepository extends CrudRepository<Societe, Integer> {
}

