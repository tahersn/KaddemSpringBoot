package tn.esprit.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Employe;
import tn.esprit.demo.repositories.IEmployeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor

public class EmployeImpl implements IEmployeService{
    @Autowired
    private  final IEmployeRepository employeRepository;
    @Override
    public Employe addEmploye(Employe e){
        return employeRepository.save(e);
    }

    @Override
    public List<Employe> retrieveAllEmployes(){
        return (List<Employe>) employeRepository.findAll();

    }
    @Override
    public Employe retrieveEmploye (Integer idEmp){
        return employeRepository.findById(idEmp).get();
    }
    @Override
    public Employe updateEmploye (Employe e){
        return  employeRepository.save(e);

    }
    @Override
    public  void deleteEmploye(Integer idEmp){
        employeRepository.deleteById(idEmp);
    }
    @Override
    public Map<String,Object>findAllEmployees(int page , int size){

        List<Employe> listEmp =new ArrayList<>();
        Pageable paging = PageRequest.of(page ,size);
        Page<Employe> pageemp = this.employeRepository.findAll(paging);
        listEmp = pageemp.getContent();
        Map<String,Object> employees = new HashMap<>();
        employees.put("employees" , listEmp);
        employees.put("pagecourante" , pageemp.getNumber());
        employees.put("totalItems" , pageemp.getTotalElements());
        employees.put("totalPage" , pageemp.getTotalPages());
        return  employees;
    }

    @Override
    public List<Employe> getEmployebyDepartements(long idDepart){
        return employeRepository.findEmployeByDepartement(idDepart);
    }
    @Override
    public List<Employe> getEmployebysoldeAfter(Integer solde){
        return employeRepository.findEmployeBySoldeAfter(solde);
    }

}
