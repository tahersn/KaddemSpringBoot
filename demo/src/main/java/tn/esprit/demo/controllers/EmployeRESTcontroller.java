package tn.esprit.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Employe;
import tn.esprit.demo.services.IEmployeService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/employe")
public class EmployeRESTcontroller {
    private final IEmployeService employeService;

    @GetMapping("/all")
    public List<Employe> getAllEmployes(){
        return employeService.retrieveAllEmployes();
    }
    @PostMapping("/add")
    public Employe addEmploye(@RequestBody Employe e){
        return employeService.addEmploye(e);
    }
    @PutMapping("/updateE")
    public Employe updateEmploye(@RequestBody Employe e){
        return employeService.updateEmploye(e);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmploye(@PathVariable("id") Integer idEmp){
        employeService.deleteEmploye(idEmp);
    }
    @GetMapping("/get/{idE}")
    public Employe getById(@PathVariable("idE") Integer idEmp){
        return employeService.retrieveEmploye(idEmp);
    }

    @GetMapping("/employees/paging")
    public ResponseEntity<Map<String,Object>> findAllByPaging(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "2") int size){
        return new ResponseEntity<>(this.employeService.findAllEmployees(page,size), HttpStatus.OK);
    }

    @GetMapping("/ListeEmp/{idDepart}")
    public List<Employe> getBydep(@PathVariable("idDepart") long idDepart){
        return employeService.getEmployebyDepartements(idDepart);
    }
    @GetMapping("/listeEmp/{solde}")
    public List<Employe> getBysoldAfter(@PathVariable("solde") Integer solde){
        return employeService.getEmployebysoldeAfter(solde);
    }


}
