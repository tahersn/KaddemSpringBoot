package tn.esprit.demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Equipe;
import tn.esprit.demo.services.IEquipeService;

import java.util.List;

@Tag(name="Equipe management")
@RestController
@RequestMapping("/equipe")
@RequiredArgsConstructor
public class EquipeRESTcontroller {
    @Autowired
    private final IEquipeService equipeImpl ;

    @Operation(description = "Ajouter une equipe ")
    @PostMapping("/add")
    public Equipe addEquipe( @RequestBody Equipe equipe){
        return equipeImpl.addEquipe(equipe);

    }
    @Operation(description = "afficher la liste des equipes ")
    @GetMapping("/equipes")
    public List<Equipe> retrieveAll(){
        return equipeImpl.retrieveAllEquipes();
    }

    @Operation(description = "afficher une equipe par son ID ")

    @GetMapping("/{id}")
    public Equipe retrieveEquipe(@PathVariable("id") Long id){
        return equipeImpl.retrieveEquipe(id);
    }
    @Operation(description = "modifier une equipe  ")

    @PutMapping("/update")
    public Equipe updateEquipe(Equipe equipe){
        return equipeImpl.updateEquipe(equipe);
    }

    @Operation(description = "add equipe and assign")
    @PostMapping("/addAndAssign")
    public Equipe AddAndAssignEquipe (Equipe equipe){
        return equipeImpl.addEquipeAndAssign(equipe);
    }
}
