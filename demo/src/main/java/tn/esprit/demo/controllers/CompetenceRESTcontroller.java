package tn.esprit.demo.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Competence;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.services.ICompetenceService;

import java.util.List;

@Tag(name="Competences Management")
@RestController
@RequestMapping("/Competence")
@AllArgsConstructor

public class CompetenceRESTcontroller {
    @Autowired
    private final ICompetenceService competenceService;

    @PostMapping("/add")
    public Competence AjouterCompetnce( @RequestBody Competence c ){
        return competenceService.AddOrUpdateCompetence(c);
    }
    @PutMapping("/update")
    public Competence ModifierCompetnce( @RequestBody Competence c ){
        return competenceService.AddOrUpdateCompetence(c);
    }
    @DeleteMapping("/delete/{idC}")
    public String DeleteCompetnce( @PathVariable("idC") Long idC ){
         competenceService.deleteCompetenceById(idC);
        return "Deleted Successfully";
    }
    @GetMapping("/get")
    public List<Competence> RetrueveAllCompetnces(  ) {
        return competenceService.retrieveAllCompetences();
    }

    @GetMapping("/get/{idC}")
    public Competence RetrueveAllCompetnces(@PathVariable("idC")Long idC  ) {
        return competenceService.retrieveCompetenceById(idC);
    }
    @PostMapping("/addAndAssignCompetence")
    public Competence AddAndAssignStToComp ( @RequestBody Competence c ){
        return competenceService.addAndAssignStudentToCompetence(c);
    }


}
