package tn.esprit.demo.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Departement;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.repositories.IDepartRepository;
import tn.esprit.demo.repositories.IEquipeRepository;
import tn.esprit.demo.repositories.IEtudRepository;

import java.util.List;
import java.util.Objects;
//@Slf4j
@Service
@RequiredArgsConstructor
public class DepartementImpl implements IDepartementService{
    @Autowired
    private final IDepartRepository departmentRepository ;
    private final IEtudiantService etudientService;

    @Override
    public Departement AddDepartement(Departement departement) {
        return departmentRepository.save(departement);
    }
    @Override
    public List<Departement> RetrieveAllDepartement() {
        List<Departement> departements ;
         departements = departmentRepository.findAll();
    return departements ;
    }

    @Override
    public Departement UpdateDepartment(Departement departement,Long id) {
        Departement dep = departmentRepository.findById(id).get();
        if (Objects.nonNull(departement.getNomDepart()) && !"".equalsIgnoreCase(departement.getNomDepart())) {
            dep.setNomDepart(departement.getNomDepart());
        }

        return departmentRepository.save(dep);
    }

    @Override
    public Departement RetrieveDepartement(Long idDepart) {
        return departmentRepository.findById(idDepart).get();

    }

    @Override
    public void DeleteDepartement(Long idDepart) {
        departmentRepository.deleteById(idDepart);
    }

    @Override
    public void affecterEtudient(Long idEtudient, Long idDepartement) {
        Etudiant etudiant = etudientService.retrieveEtudiant(idEtudient);
        Departement departement = RetrieveDepartement(idDepartement);
        etudiant.setDepartement(departement);
        etudientService.addOrupdateEtudiant(etudiant);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Long idUniv) {
        return departmentRepository.retrieveDepartementsByUniversite(idUniv);
    }


    // @Scheduled(cron="*/15 * * * * *")
   // public void bonjour(){
      //  log.info("Hello");
   // }

}

