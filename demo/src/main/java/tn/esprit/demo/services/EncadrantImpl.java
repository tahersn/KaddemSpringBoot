package tn.esprit.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Encadrant;
import tn.esprit.demo.entities.Societe;
import tn.esprit.demo.repositories.IEncadrantRepository;
import tn.esprit.demo.repositories.ISocieteRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class EncadrantImpl implements IEncadrantService {
    @Autowired
    IEncadrantRepository encadrantRepository;
    @Autowired
    ISocieteRepository societeRepository;
    @Override
    public List<Encadrant> getAllEncadrant() {
        List<Encadrant> encadrants = new ArrayList<Encadrant>();
        encadrantRepository.findAll().forEach(encadrants::add);
        return encadrants;
    }
    @Override
    public Encadrant getEncadrantById(int idEncadrant) {
        return encadrantRepository.findById(idEncadrant).get();
    }
    @Override
    public boolean update(Encadrant encadrant) {
        if (encadrantRepository.existsById(encadrant.getIdEnc())) {
            encadrantRepository.save(encadrant);
            return true;
        }
        return false;
    }
    @Override
    public int ajoutEncadrant(Encadrant encadrant) {
        encadrantRepository.save(encadrant);
        return encadrant.getIdEnc();
    }
    @Override
    public boolean deleteEncadrantById(int idEnc) {
        if (encadrantRepository.existsById(idEnc)) {
            encadrantRepository.deleteById(idEnc);
            return true;
        }
        return false;
    }
    @Override
    public Encadrant assignEncadrantToSociete(int idEncadrant, int idSociete) {
        Encadrant e = encadrantRepository.findById(idEncadrant).get();
        Societe s = societeRepository.findById(idSociete).get();
        e.setSociete(s);
        encadrantRepository.save(e);

        return e;
    }
}