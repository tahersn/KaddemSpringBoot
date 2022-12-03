package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Departement;


@Repository
public interface IDepartRepository extends JpaRepository<Departement,Long> {




}
