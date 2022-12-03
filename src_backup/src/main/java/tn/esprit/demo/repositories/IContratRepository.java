package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Contrat;

import java.util.Date;
import java.util.List;

@Repository
public interface IContratRepository extends JpaRepository<Contrat,Long> {

   /* @Query("select c from Contrat c where c.dateFinContrat between ?1 and ?2")
    List<Contrat> findByDateFinContratBetween(Date dateFinContratStart, Date dateFinContratEnd);*/
    List<Contrat> countByArchiveIsFalseAndDateDebutContratBetween(Date startDate , Date endDate);

    @Query("select c from Contrat c where c.dateFinContrat between ?1 and ?2")
    List<Contrat> findByDateFinContratBetween(Date dateFinContratStart, Date dateFinContratEnd);
}
