package tn.esprit.demo.services;


import tn.esprit.demo.entities.Employe;

import java.util.List;
import java.util.Map;

public interface IEmployeService {
    public Employe addEmploye(Employe e);

    public List<Employe> retrieveAllEmployes();
    public Employe retrieveEmploye (Integer idEmp);
    public Employe updateEmploye (Employe e);
    public  void deleteEmploye(Integer idEmp);

    Map<String,Object>findAllEmployees(int page , int size);

    List<Employe> getEmployebyDepartements(long idDepart);

    List<Employe> getEmployebysoldeAfter(Integer solde);
}
