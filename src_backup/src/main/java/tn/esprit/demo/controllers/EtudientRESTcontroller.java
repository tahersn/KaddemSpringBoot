package tn.esprit.demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.services.IEtudiantService;

import java.util.List;

@Tag(name="gestion des etudients ")
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class EtudientRESTcontroller {
    @Autowired
    private final IEtudiantService etudientImpl;

    @Operation(description = "Ajouter un etudient")
    @PostMapping ("/add")
    public Etudiant AddStudent(@RequestBody Etudiant etudiant){
        return etudientImpl.addOrupdateEtudiant(etudiant);
    }

    @Operation(description = "Afficheer un etudient par son ID")
    @GetMapping("/get/{idEtudient}")
    public Etudiant getetudient (int id){
        return etudientImpl.retrieveEtudiant(id);
    }

    @Operation(description = "Ajouter un etudient dans une equipe et contrat")
    @PostMapping("/assign/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody  Etudiant e, @PathVariable("idContrat") Long idContrat, @PathVariable("idEquipe") Long
            idEquipe){

        return etudientImpl.addAndAssignEtudiantToEquipeAndContract(e, idContrat,idEquipe);
    }

    @Operation(description = "Afficher un etudient par son prenom")
    @GetMapping("/getStudent/{pre}")
    public Etudiant findByprenom(@PathVariable("pre")String pre){
        return etudientImpl.findByPrenomE(pre);
    }

    @Operation(description = "Delete Student")
    @DeleteMapping("/delete/{id}")
    public  String DeleteEtudiant(@PathVariable("id") Integer id) {
        etudientImpl.removeEtudiant(id);
        return ("deleted succesfuly");
    }

     @Operation(description = "Afficher la liste des etudients ")
    @GetMapping("/GetAll")
    public List<Etudiant> FindAllStudents (){
        return etudientImpl.retrieveAllStudents();
     }


}
