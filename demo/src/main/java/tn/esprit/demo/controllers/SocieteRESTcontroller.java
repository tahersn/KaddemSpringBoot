package tn.esprit.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Societe;
import tn.esprit.demo.services.ISocieteService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/societe")
public class SocieteRESTcontroller {

    ISocieteService societeService;
    @GetMapping("/retrieve-all-societe")
    public List<Societe> getAllSociete()
    {
        List<Societe> societes = societeService.getAllSociete();
        return societes;
    }
    @GetMapping("/retrieve-all-societes/{societe-id}")
    public Societe getSocieteById(@PathVariable("societe-id") int id)
    {

        return societeService.getSocieteById(id);
    }


    @PutMapping("/update-societe-by-id")
    public boolean update(@RequestBody Societe societe)
    {
        return societeService.update(societe);


    }

    @PostMapping("/add-societe")
    public int ajoutContrat(@RequestBody Societe societe) {
        return societeService.ajoutSociete(societe);

    }


    @DeleteMapping("/delete-societe/{societe-id}")
    public boolean deleteSocieteById(@PathVariable("societe-id") int idSociete) {
        return  societeService.deleteSocieteById(idSociete);
    }




}
