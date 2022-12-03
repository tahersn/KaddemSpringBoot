package tn.esprit.demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Departement;
import tn.esprit.demo.services.IDepartementService;

import java.util.List;
@Tag(name ="Departement management")
@RestController
@RequestMapping("/departement")
@RequiredArgsConstructor

public class DepartementRESTcontroller {
    @Autowired
    private final IDepartementService departementImpl ;
    @Operation(description = "ajouter un departement  ")

    @PostMapping("/add")
    public Departement AddDepartment ( @RequestBody  Departement departement){
        return departementImpl.AddDepartement(departement);
    }
    @Operation(description = "afficher les departements ")

    @GetMapping("/departements")
    public List<Departement> RetrieveAllDepartements() {
        return departementImpl.RetrieveAllDepartement();
    }

    @Operation(description = "afficher un departement ")

    @GetMapping("/{id}")
    public Departement RetrieveDepartement(@PathVariable("id") Long id){
        return departementImpl.RetrieveDepartement(id);
    }
    @Operation(description = "modifier un departement ")

    @PutMapping("/{id}")
    public Departement UpdateDepartement(@RequestBody Departement departement , @PathVariable Long id ){
        return departementImpl.UpdateDepartment(departement,id);
    }
    @Operation(description = "Supprimer un departement ")

    @DeleteMapping("/{id}")
    public String deleteDepartement (@PathVariable Long id ){
        departementImpl.DeleteDepartement(id);
        return "Deleted successfully";
    }
    @Operation(description = "assign student")
    @PutMapping("/assign/{idE}/{idDep}")
    public void assignStudent(@PathVariable("idDep") Long idDep,@PathVariable("idE")Long idE ){
        departementImpl.affecterEtudient(idE,idDep);
    }

    @GetMapping("/byUniv/{idUniv}")
    public List<Departement> FindByIdUniv(@PathVariable("idUniv")Long idUniv){
        return departementImpl.retrieveDepartementsByUniversite(idUniv);
    }

}
