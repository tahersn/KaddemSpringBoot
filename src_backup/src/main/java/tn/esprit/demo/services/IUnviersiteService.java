package tn.esprit.demo.services;

import tn.esprit.demo.entities.Universite;

import java.util.List;

public interface IUnviersiteService {
   public List<Universite> retrieveAllUniversites();

    public Universite addUniversite (Universite u);

    public Universite updateUniversite (Universite u);

   public Universite retrieveUniversite (Long idUniversite);

    public void assignUniversiteToDepartement(Long idUniversite, Long idDepartement);
}
