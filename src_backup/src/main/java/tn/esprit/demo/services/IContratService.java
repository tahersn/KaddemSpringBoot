package tn.esprit.demo.services;

import tn.esprit.demo.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {

    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);

    Contrat addContrat (Contrat ce);

    Contrat retrieveContrat (Long idContrat);

    void removeContrat(Long idContrat);

    List<Contrat> countByArchiveIsFalseAndDateDebutContratBetween(Date startDate , Date endDate);

   Contrat affectContratToEtudiant (Contrat ce , String nomE, String prenomE);
}
