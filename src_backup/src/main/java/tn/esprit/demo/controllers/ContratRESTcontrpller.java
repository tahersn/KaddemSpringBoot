package tn.esprit.demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Contrat;
import tn.esprit.demo.services.IContratService;

import java.util.Date;
import java.util.List;
@Tag(name="Contrat management ")
@RestController
@RequestMapping("/contrat")
@RequiredArgsConstructor
public class ContratRESTcontrpller {
    @Autowired
    private final IContratService contratImpl ;
    @Operation(description = "ajouter un contrat ")

    @PostMapping("/add")
    public Contrat addContrat(@RequestBody  Contrat contrat){
        return contratImpl.addContrat(contrat);
    }

    @Operation(description = "Afficher les contrats")
    @GetMapping("/contrats")

    public List<Contrat> GetAllContrats(){
        return contratImpl.retrieveAllContrats();
    }

    @Operation(description = "afficer un contrat")
    @GetMapping("/{id}")
    public Contrat GetContrat (@PathVariable("id") Long id){
        return contratImpl.retrieveContrat(id);
    }

    @Operation(description = "Supprimer un contrat ")
    @DeleteMapping("/{id}")
    public String DeleteContrat (@PathVariable ("id") Long id){
        contratImpl.removeContrat(id);
        return "Deleted successfully";
    }

    @Operation(description = "Modifier un contrat")
    @PutMapping("/update")
    public Contrat updateContrat (@RequestBody Contrat contrat  ){
        return contratImpl.updateContrat(contrat);
    }

    @Operation(description = "afficher le nombre des contrats valides ")
    @GetMapping("/GetContratValide/{startDate}/{endDate}")
     public List<Contrat> nbContratsValides(@PathVariable("startDate")Date startDate , @PathVariable("endDate")  Date endDate){
        return contratImpl.countByArchiveIsFalseAndDateDebutContratBetween(startDate,endDate);

    }
    @Operation(description = "affectation contrat a etudiant")
    @PostMapping ("affectation/{nomE}/{prenomE}")
    public  Contrat affecterContratAEtudient(@RequestBody Contrat ce ,@PathVariable("nomE") String nomE,@PathVariable("prenomE")String prenomE){
        return contratImpl.affectContratToEtudiant(ce,nomE,prenomE);
    }
}
