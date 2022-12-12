package tn.esprit.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Encadrant;

@Repository
public interface IEncadrantRepository extends CrudRepository<Encadrant, Integer> {
}