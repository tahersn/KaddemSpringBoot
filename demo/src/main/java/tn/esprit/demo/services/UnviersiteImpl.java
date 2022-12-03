package tn.esprit.demo.services;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Departement;
import tn.esprit.demo.entities.Universite;
import tn.esprit.demo.repositories.IDepartRepository;
import tn.esprit.demo.repositories.IUniversiteRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UnviersiteImpl implements IUnviersiteService{
    @Autowired
    private final IUniversiteRepository universiteRepository;
    private final IDepartementService departementService ;
    @Override
    public List<Universite> retrieveAllUniversites() {
        List<Universite> universites;
        universites = universiteRepository.findAll();
        return universites;
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public void assignUniversiteToDepartement(Long idUniversite, Long idDepartement) {
        Departement departement = departementService.RetrieveDepartement(idDepartement);
        Universite universite = retrieveUniversite(idUniversite);
        if(universite.getDepartements()==null){
            Set<Departement> departments=new HashSet<>();
            departments.add(departement);
        }
        else {
            universite.getDepartements().add(departement);
        }
        universiteRepository.save(universite);
    }
}
