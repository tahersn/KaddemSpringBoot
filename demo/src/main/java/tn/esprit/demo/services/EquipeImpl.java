package tn.esprit.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.DetailEquipe;
import tn.esprit.demo.entities.Equipe;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.repositories.IDetailEqRepository;
import tn.esprit.demo.repositories.IEquipeRepository;
import tn.esprit.demo.repositories.IEtudRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EquipeImpl implements IEquipeService{
    @Autowired
     private final IEquipeRepository equipeRepository;
    private final IDetailEqRepository detailEqRepository;
    private final IEtudRepository etudiantRepo;

    @Override
    public Equipe addEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public List<Equipe> retrieveAllEquipes() {
        List<Equipe> equipes ;
        equipes= equipeRepository.findAll();
        return equipes ;
    }

    @Override
    public Equipe retrieveEquipe(Long idEquipe) {
        return equipeRepository.findById(idEquipe).get();
    }

    @Override
    public Equipe updateEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe addEquipeAndAssign(Equipe equipe) {
        DetailEquipe detailEquipe = equipe.getDetailEquipe_pk();
        detailEquipe.setEquipe(equipe);
        detailEqRepository.save(detailEquipe);
        System.out.println(equipe.getEtudiants().toString());
        for(Etudiant etudiant :equipe.getEtudiants()){
            if (etudiant.getEquipes()==null){
                Set<Equipe> equipes =new HashSet<>();
                equipes.add(equipe);
                etudiant.setEquipes(equipes);
            }
            else{
                etudiant.getEquipes().add(equipe);
            }
            etudiantRepo.save(etudiant);

        }
        return equipe;
    }

}
