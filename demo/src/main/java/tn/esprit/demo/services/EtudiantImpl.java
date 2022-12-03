package tn.esprit.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Contrat;
import tn.esprit.demo.entities.Equipe;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.repositories.IContratRepository;
import tn.esprit.demo.repositories.IEquipeRepository;
import tn.esprit.demo.repositories.IEtudRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantImpl implements IEtudiantService {
    private final IEtudRepository etudRepository;
    private final IContratRepository contratRepository;
    private final IEquipeRepository equipeRepository;


    @Override
    public Etudiant addOrupdateEtudiant(Etudiant etudiant) {
        return etudRepository.save(etudiant);
    }



    @Override
    public List<Etudiant> retrieveAllStudents() {
        List<Etudiant> etudiants ;
        etudiants = (List<Etudiant>) etudRepository.findAll();
        return etudiants ;
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




}
