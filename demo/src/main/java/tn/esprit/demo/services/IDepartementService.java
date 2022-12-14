package tn.esprit.demo.services;

import tn.esprit.demo.entities.Departement;

import java.util.List;

public interface IDepartementService {
    public Departement AddDepartement(Departement departement);



    public List<Departement> RetrieveAllDepartement();

    public Departement UpdateDepartment (Departement departement , Long id);


    Departement updateDepartement (Departement d);


    Departement RetrieveDepartement(Long idDepart);

    void DeleteDepartement (Long idDepart);

    public void affecterEtudient (Long idEtudient,Long idDepartement);
    public void affecterEmployee (Integer idEmp,Long idDepartement);
    List<Departement> retrieveDepartementsByUniversite(Long idUniv);

}
