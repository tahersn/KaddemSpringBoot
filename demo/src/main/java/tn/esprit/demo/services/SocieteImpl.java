package tn.esprit.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.demo.entities.Societe;
import tn.esprit.demo.repositories.ISocieteRepository;

import java.util.ArrayList;
import java.util.List;

public class SocieteImpl implements ISocieteService {

    ISocieteRepository societeRepository;

    @Override
    public List<Societe> getAllSociete() {
        List<Societe> societes = new ArrayList<Societe>();
        societeRepository.findAll().forEach(societes::add);
        return societes; }

    @Override
    public Societe getSocieteById(int idSociete) {
        return societeRepository.findById(idSociete).get();
    }

    @Override
    public boolean update(Societe societe) {
        if (societeRepository.existsById(societe.getIdS())){
            societeRepository.save(societe);
            return true;
        }
        return false;
    }

    @Override
    public int ajoutSociete(Societe societe) {
        societeRepository.save(societe);
        return societe.getIdS();
    }

    @Override
    public boolean deleteSocieteById(int idSociete) {
        if (societeRepository.existsById(idSociete)) {
            societeRepository.deleteById(idSociete);
            return true;
        }
        return false;
    }
}


