package tn.esprit.demo.services;

import tn.esprit.demo.entities.Encadrant;

import java.util.List;

public interface IEncadrantService {
    public List<Encadrant> getAllEncadrant();
    public Encadrant getEncadrantById(int id);
    public boolean update(Encadrant encadrant);

    public int ajoutEncadrant(Encadrant encadrant);


    boolean deleteEncadrantById(int idEnc);
    public Encadrant assignEncadrantToSociete(int idEncadrant, int idSociete);
}
