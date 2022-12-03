package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Universite;
@Repository
public interface IUniversiteRepository extends JpaRepository<Universite,Long> {
}
