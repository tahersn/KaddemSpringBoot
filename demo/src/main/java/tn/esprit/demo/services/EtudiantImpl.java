package tn.esprit.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Competence;
import tn.esprit.demo.entities.Contrat;
import tn.esprit.demo.entities.Equipe;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.repositories.ICompetenceRepository;
import tn.esprit.demo.repositories.IContratRepository;
import tn.esprit.demo.repositories.IEquipeRepository;
import tn.esprit.demo.repositories.IEtudRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EtudiantImpl implements IEtudiantService {
    @Autowired
    private final IEtudRepository etudRepository;
    private final IContratRepository contratRepository;
    private final IEquipeRepository equipeRepository;
    @Autowired
    private final ICompetenceRepository competenceRepository;


    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudRepository.save(etudiant);
    }
    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudRepository.save(etudiant);
    }


    @Override
    public List<Etudiant> retrieveAllStudents() {
        return (List<Etudiant>) etudRepository.findAll();

    }

    @Override
    public void removeEtudiant(Long id) {
        etudRepository.deleteById(id);}


    @Override
    public Etudiant retrieveEtudiant(Long id) {

        return etudRepository.findById(id).get();
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe) {
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        //affectation contrat(oneToMany )
        contrat.setEtudiant(e);
        //affectation equipe (ManyToMany)
        e.getEquipes().add(equipe);
        etudRepository.save(e);

        contratRepository.save(contrat);
        return e ;
    }

    @Override
    public Etudiant findByPrenomE(String pre) {
        return etudRepository.findByPrenomE(pre);
    }

    @Override
    public Etudiant findByPrenomEAndNomE(String nomE, String prenomE) {
        return etudRepository.findByPrenomEAndNomE(nomE,prenomE);
    }

    @Override
    public List<Etudiant> findByDepartement_IdDepart(Long idDepart) {
        return etudRepository.findByDepartement_IdDepart(idDepart);
    }





    /*@Override
    public List<Etudiant> retrieveEtudientparoption(String Option) {
        return etudRepository.retrieveEtudientparoption(Option);
    }*/

    @Override
    public void AssignCompetenceToStudent(Long idE, Long idC) {
       Competence c = competenceRepository.findById(idC).orElse(null);
       Etudiant e =etudRepository.findById(idE).orElse(null);
       System.out.println(c.getNomCompetnce());
       System.out.println(e.getNomE());
      /* if (e.getCompetences()==null){
            Set<Competence> Competences =new HashSet<>();
            Competences.add(c);
        }else*/
            e.getCompetences().add(c);
        etudRepository.save(e);

    }

    @Override
    public List<Etudiant> getBy(String prenomE, String nomE, String option) {
        return etudRepository.findByArgs(prenomE, nomE, option);
    }

    @Override
    public List<Etudiant> getAllOrderByIddesc() {
        return etudRepository.findByOrderByIdEtudiantDesc();
    }


}
