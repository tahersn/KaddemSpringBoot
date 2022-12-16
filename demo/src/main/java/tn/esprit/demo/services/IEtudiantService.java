package tn.esprit.demo.services;

import tn.esprit.demo.entities.Competence;
import tn.esprit.demo.entities.Contrat;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.entities.Option;

import java.util.List;

public interface IEtudiantService {


    public Etudiant addOrUpdateEtudiant(Etudiant etudiant);

    List<Etudiant>  retrieveAllStudents ();
    public void removeEtudiant(Long id);

    public Etudiant retrieveEtudiant(Long id);
    public  Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe);
    /*List<Etudiant> retrieveEtudientparoption(String Option);*/

    Etudiant findByPrenomE(String pre);
    Etudiant findByPrenomEAndNomE ( String nomE, String prenomE);
    List<Etudiant> findByDepartement_IdDepart(Long idDepart);
   void AssignCompetenceToStudent(Long idE, Long idC);
    public List<Etudiant> getBy(String prenomE, String nomE, Option option);

    List<Etudiant> getAllOrderByIddesc();

}
