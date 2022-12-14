package tn.esprit.demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Competence;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.entities.Option;
import tn.esprit.demo.services.IEtudiantService;

import java.util.ArrayList;
import java.util.List;

@Tag(name="gestion des etudients ")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class EtudientRESTcontroller {
    @Autowired
    private final IEtudiantService etudientImpl;

    @Operation(description = "Ajouter un etudient")
    @PostMapping ("/add")
    public Etudiant AddStudent(@RequestBody Etudiant etudiant){
        return etudientImpl.addOrUpdateEtudiant(etudiant);
    }

    @Operation(description = "Afficheer un etudient par son ID")
    @GetMapping("/get/{idEtudient}")
    public Etudiant getetudient (@PathVariable("idEtudient")Long id){
        return etudientImpl.retrieveEtudiant(id);
    }

    @Operation(description = "Ajouter un etudient dans une equipe et contrat")
    @PostMapping ("/assign/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody  Etudiant e, @PathVariable("idContrat") Long idContrat,@PathVariable("idEquipe") Long
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
    public  void DeleteEtudiant(@PathVariable("id") Long id) {
        etudientImpl.removeEtudiant(id);
    }

     @Operation(description = "Afficher la liste des etudients ")
    @GetMapping("/GetAll")
    public List<Etudiant> FindAllStudents (){
        return etudientImpl.retrieveAllStudents();
     }


    @GetMapping("/dep/{idDep}")
    public List<Etudiant> FindByDepId (@PathVariable("idDep")Long idDep){
        return etudientImpl.findByDepartement_IdDepart(idDep);
    }
    @GetMapping("/find/{nomE}/{prenomE}")
    public Etudiant findByFnameAndLname(@PathVariable("nomE")String nomE,@PathVariable("prenomE")String prenomE){

               Etudiant e=etudientImpl.findByPrenomEAndNomE(nomE,prenomE);
        return e;
    }
    @PutMapping("/assignC/{idE}/{idC}")
    public void AddAndAssignCompetence(@PathVariable("idE")Long idE, @PathVariable("idC") Long idC){
         etudientImpl.AssignCompetenceToStudent(idE,idC);
    }

    @PutMapping("/update")
    public Etudiant updateStudent (@RequestBody Etudiant etudiant){
        return  etudientImpl.addOrUpdateEtudiant(etudiant);
    }
    @GetMapping("/")
    @ResponseBody
    public List<Etudiant> get(
            @RequestParam(required = false) Long idE,
            @RequestParam(required = false) String prenomE,
            @RequestParam(required = false) String nomE,
            @RequestParam(required = false) Option option
    ) {

        List<Etudiant> students = new ArrayList<Etudiant>();

        if (idE != null) {
            students.add(etudientImpl.retrieveEtudiant(idE));
            return students;
        }
        if (prenomE != null || nomE != null || option != null ) {
            students = etudientImpl.getBy(prenomE, nomE, option);
            return students;
        }

        students = etudientImpl.retrieveAllStudents();
        return students;
    }

    @GetMapping("/getAllDesc")
    public List<Etudiant> getAllOrderBy(){
        return etudientImpl.getAllOrderByIddesc();
    }


}
