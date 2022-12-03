package tn.esprit.demo.services;

import tn.esprit.demo.entities.Departement;

import java.util.List;

public interface IDepartementService {
    public Departement AddDepartement(Departement departement);



    public List<Departement> RetrieveAllDepartement();

    public Departement UpdateDepartment (Departement departement , Long id);




    Departement RetrieveDepartement(Long idDepart);

    void DeleteDepartement (Long idDepart);

    public void affecterEtudient (Integer idEtudient,Long idDepartement);

}
