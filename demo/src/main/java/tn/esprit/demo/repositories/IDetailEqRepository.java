package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.DetailEquipe;
@Repository
public interface IDetailEqRepository extends JpaRepository<DetailEquipe,Long> {
}
