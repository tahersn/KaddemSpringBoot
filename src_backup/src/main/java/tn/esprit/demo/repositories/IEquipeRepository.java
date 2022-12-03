package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Equipe;
@Repository
public interface IEquipeRepository  extends JpaRepository<Equipe,Long > {
}
