package tn.esprit.demo.services;

import tn.esprit.demo.entities.Societe;

import java.util.List;

public interface ISocieteService {
    public List<Societe> getAllSociete();
    public Societe getSocieteById(int idSociete);
    public boolean update(Societe societe);

    public int ajoutSociete(Societe societe);


    boolean deleteSocieteById(int idSociete);
}