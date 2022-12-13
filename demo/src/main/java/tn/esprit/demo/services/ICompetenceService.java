package tn.esprit.demo.services;

import tn.esprit.demo.entities.*;

import java.util.List;

public interface ICompetenceService {
     Competence AddOrUpdateCompetence (Competence c);
     List<Competence> retrieveAllCompetences();
     Competence retrieveCompetenceById(Long idC);
     void deleteCompetenceById(Long idC);
     Competence addAndAssignStudentToCompetence ( Competence c);
     Competence finBYArgs(String nomCompetence, Type type , NiveauCompetence NiveauC);




}
