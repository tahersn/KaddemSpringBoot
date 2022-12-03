package tn.esprit.demo.services;

import tn.esprit.demo.entities.Contrat;
import tn.esprit.demo.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {


    public Etudiant addOrupdateEtudiant(Etudiant etudiant);

    List<Etudiant>  retrieveAllStudents ();
    public void removeEtudiant(Integer id);

    public Etudiant retrieveEtudiant(Integer id);
   public  Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe);
    /*List<Etudiant> retrieveEtudientparoption(String Option);

    List<Etudiant> retrieveEtudientparDepartement(String nomDEp);*/
    Etudiant findByPrenomE(String pre);
    Etudiant findByPrenomEAndNomE ( String nomE, String prenomE);


}
