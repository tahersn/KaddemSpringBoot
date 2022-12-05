package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Competence;
@Repository
public interface ICompetenceRepository extends CrudRepository<Competence,Long> {
}
