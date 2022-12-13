package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Competence;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.entities.NiveauCompetence;
import tn.esprit.demo.entities.Type;

import java.util.List;

@Repository
public interface ICompetenceRepository extends CrudRepository<Competence,Long> {
    final String getQuery = "" +
            "SELECT c " +
            "FROM Competence c " +
            "WHERE " +
            "(:nomCompetnce IS NULL OR c.nomCompetnce = :nomCompetnce) " +
            "AND (:type IS NULL OR c.type = :type) " +
            "AND (:NiveauC IS NULL OR c.NiveauC = :NiveauC) " ;

    @Query(getQuery)
    public List<Competence> findByArgs(
            @Param("nomCompetnce") String nomCompetnce,
            @Param("type") Type type,
            @Param("NiveauC") NiveauCompetence NiveauC
    );
}
