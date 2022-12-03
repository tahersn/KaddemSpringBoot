package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Departement;

import java.util.List;


@Repository
public interface IDepartRepository extends JpaRepository<Departement,Long> {
    @Query("SELECT departement FROM Departement departement,Universite universite inner JOIN universite.departements d ON d.idDepart=departement.idDepart and universite.idUniv=:idUniv  ")
    List<Departement> retrieveDepartementsByUniversite(Long idUniv);



}
