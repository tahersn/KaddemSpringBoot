package tn.esprit.demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Universite;
import tn.esprit.demo.services.IUnviersiteService;

import java.util.List;
@Tag(name="University Management ")
@RestController
@RequestMapping("/universite")
@RequiredArgsConstructor
public class UiversiteRESTcontroller {
    @Autowired
    private final IUnviersiteService universiteImpl ;

    @Operation(description = "Ajouter une université")
    @PostMapping("/add")
    public Universite addUniversite (@RequestBody Universite u){
        return universiteImpl.addUniversite(u);
    }

    @Operation(description = "retrieve All universites")
    @GetMapping("/universites")

    public List<Universite> retrieveAllUniversites (){
        return universiteImpl.retrieveAllUniversites();
    }

    @Operation(description = "Get Université par ID")
    @GetMapping("/{id}")

    public Universite retrieveUniversite (@PathVariable("id") Long id){
        return universiteImpl.retrieveUniversite(id);
    }

    @Operation(description = " Update université")

    @PutMapping("/update")

    public Universite UpdateUniversite(Universite u){
        return universiteImpl.updateUniversite(u);

    }

    @Operation(description = "assign departement to university")
    @PutMapping("/assignDepartemnt/{idDep}/{idUniversity}")

    public void assignDepartement(@PathVariable("idDep")Long idDep,@PathVariable("idUniversity") Long idUniversity){
        universiteImpl.assignUniversiteToDepartement(idDep,idUniversity);
    }
}
