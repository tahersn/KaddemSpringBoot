package tn.esprit.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Competence;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.entities.NiveauCompetence;
import tn.esprit.demo.entities.Type;
import tn.esprit.demo.repositories.ICompetenceRepository;
import tn.esprit.demo.repositories.IEtudRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CompetenceImpl implements ICompetenceService {
    @Autowired
    private final ICompetenceRepository competenceRepository ;
    private final IEtudRepository etudiantRepository;

    @Override
    public Competence AddOrUpdateCompetence(Competence c) {
        return competenceRepository.save(c);
    }

    @Override
    public List<Competence> retrieveAllCompetences() {
        List<Competence> Competences;
        Competences= (List<Competence>) competenceRepository.findAll();
        return  Competences;
    }

    @Override
    public Competence retrieveCompetenceById(Long idC) {
        return competenceRepository.findById(idC).get();
    }

    @Override
    public void deleteCompetenceById(Long idC) {
         competenceRepository.deleteById(idC);
    }
    @Override
    public Competence addAndAssignStudentToCompetence(Competence c) {
        for (Etudiant e : c.getEtudiants()) {
            Set<Competence> Competences = new HashSet<>();
            e.setCompetences(Competences);
            e.getCompetences().add(c);
            etudiantRepository.save(e);
        }
        return competenceRepository.save(c);
    }

    @Override
    public Competence finBYArgs(String nomCompetence, Type type, NiveauCompetence NiveauC) {

        return (Competence) competenceRepository.findByArgs(nomCompetence,type,NiveauC);
    }


}
