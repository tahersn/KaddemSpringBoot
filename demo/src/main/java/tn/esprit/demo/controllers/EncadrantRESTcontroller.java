package tn.esprit.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Encadrant;
import tn.esprit.demo.services.IEncadrantService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/encadrant")

public class EncadrantRESTcontroller {
    @Autowired
    IEncadrantService encadrantService;
    @GetMapping("/retrieve-all-encadrants")
    public List<Encadrant> getAllEncadrants()
    {
        List<Encadrant> encadrants = encadrantService.getAllEncadrant();
        return encadrants;
    }

    @GetMapping("/retrieve-all-encadrants/{encadrant-id}")
    public Encadrant getEncadrantById(@PathVariable("encadrant-id") int id)
    {

        return encadrantService.getEncadrantById(id);
    }


    @PutMapping("/update-encadrant-by-id")
    public boolean update(@RequestBody Encadrant encadrant)
    {
        return encadrantService.update(encadrant);


    }

    @PostMapping("/add-encadrant")
    public int ajoutEncadrant(@RequestBody Encadrant encadrant) {
        return encadrantService.ajoutEncadrant(encadrant);

    }


    @DeleteMapping("/delete-encdrant/{encadrant-id}")
    public boolean deleteEncadrantById(@PathVariable("encadrant-id") int idEnc) {
        return  encadrantService.deleteEncadrantById(idEnc);
    }

    @PostMapping("/assign-Encadrant-to-societe/{id-encadrant}/{id-societe}")
    public Encadrant assignEncadrantToSociete(@PathVariable("id-encadrant") int idEncadrant,@PathVariable("id-societe") int idSociete){
        return encadrantService.assignEncadrantToSociete(idEncadrant,idSociete);
    }
}
