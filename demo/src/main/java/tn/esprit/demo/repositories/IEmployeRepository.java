package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.demo.entities.Employe;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeRepository extends JpaRepository<Employe,Integer> {
    @Query("select e from Employe e inner join e.departement ee where ee.idDepart = ?1")
    List<Employe> findEmployeByDepartement(long idDepart);

    @Query("Select e From Employe e where e.solde  > :solde ")
    List<Employe> findEmployeBySoldeAfter(@Param("solde")Integer solde);

}
