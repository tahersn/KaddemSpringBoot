package tn.esprit.demo.services;

import tn.esprit.demo.entities.Contrat;
import tn.esprit.demo.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {


    public Etudiant addEtudiant(Etudiant etudiant);
    public Etudiant updateEtudiant(Etudiant etudiant);

    List<Etudiant>  retrieveAllStudents ();
    public void removeEtudiant(Long id);

    public Etudiant retrieveEtudiant(Long id);
    public  Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe);
    /*List<Etudiant> retrieveEtudientparoption(String Option);*/

    Etudiant findByPrenomE(String pre);
    Etudiant findByPrenomEAndNomE ( String nomE, String prenomE);
    List<Etudiant> findByDepartement_IdDepart(Long idDepart);


}
