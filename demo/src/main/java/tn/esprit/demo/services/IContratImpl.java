package tn.esprit.demo.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Contrat;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.repositories.IContratRepository;
import tn.esprit.demo.repositories.IEtudRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class IContratImpl implements IContratService {
    @Autowired
    private final IContratRepository contratRepository;
    private final IEtudRepository etudiantRepo;

    @Override
    public List<Contrat> retrieveAllContrats() {
        List<Contrat> contrats ;
        contrats = contratRepository.findAll();
        return contrats;
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Long idContrat) {
        return contratRepository.findById(idContrat).get();
    }

    @Override
    public void removeContrat(Long idContrat) {
        contratRepository.deleteById(idContrat);

    }

    @Override
    public List<Contrat> countByArchiveIsFalseAndDateDebutContratBetween(Date startDate, Date endDate) {
        return contratRepository.countByArchiveIsFalseAndDateDebutContratBetween(startDate,endDate);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant etudiant = etudiantRepo.findByPrenomEAndNomE(nomE,prenomE);
        System.out.println(etudiant);
        if(etudiant.getContrats().stream().count()<5){
            ce.setEtudiant(etudiant);
            etudiant.getContrats().add(ce);
            return ce;

        } else
            return null;
    }
   // @Scheduled(cron="*/15 * * * * *")
   /* public void retrieveStatusContrat(){
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, 15);
        List<Contrat> contrats =contratRepository.findByDateFinContratBetween(today,cal.getTime());
        contrats.forEach(contrat -> {
            contrat.setArchive(true);});

        String res=contrats.toString();
        log.warn(res);

       // return res;
    }*/


}
