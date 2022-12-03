package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.entities.Option;

import java.util.List;

public interface IEtudRepository extends CrudRepository<Etudiant,Long> {
    @Query("select e from Etudiant e where e.departement.idDepart = ?1")
    List<Etudiant> findByDepartement_IdDepart(long idDepart);


    @Query("select e from Etudiant e where e.prenomE = ?1")
    Etudiant findByPrenomE(String prenomE);

    @Query("select e from Etudiant e where e.option = ?1")
    Etudiant findByOption(Option option);

     Etudiant findByPrenomEAndNomE ( String nomE, String prenomE);



     //Etudiant findByContratsIsLessThan(Integer n);



   /* @Query("select e from Etudiant e where e.option = :option")
    List<Etudiant> retrieveEtudientparoption (@Param("option") String option);


    @Query("select e from Etudiant e where e.departement.nomDepart = :nomDep ")
    List<Etudiant> retrieveEtudientparDepartement  (@Param("nomDep") String nomDepartement );

    List <Etudiant> findstudentbyoption (Option op);*/




}
