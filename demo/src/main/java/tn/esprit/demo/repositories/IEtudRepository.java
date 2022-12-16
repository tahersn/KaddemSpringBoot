package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

    @Query("select e from Etudiant e order by e.idEtudiant DESC")
    List<Etudiant> findByOrderByIdEtudiantDesc();



     Etudiant findByPrenomEAndNomE ( String nomE, String prenomE);

    final String getQuery = "" +
            "SELECT e " +
            "FROM Etudiant e " +
            "WHERE " +
            "(:prenomE IS NULL OR e.prenomE = :prenomE) " +
            "AND (:nomE IS NULL OR e.nomE = :nomE) " +
            "AND (:option IS NULL OR e.option = :option) " ;

    @Query(getQuery)
    public List<Etudiant> findByArgs(
            @Param("prenomE") String prenomE,
            @Param("nomE") String nomE,
            @Param("option") Option option
    );



     //Etudiant findByContratsIsLessThan(Integer n);



   /* @Query("select e from Etudiant e where e.option = :option")
    List<Etudiant> retrieveEtudientparoption (@Param("option") String option);


    @Query("select e from Etudiant e where e.departement.nomDepart = :nomDep ")
    List<Etudiant> retrieveEtudientparDepartement  (@Param("nomDep") String nomDepartement );

    List <Etudiant> findstudentbyoption (Option op);*/




}
