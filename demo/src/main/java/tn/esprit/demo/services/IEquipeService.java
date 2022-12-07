package tn.esprit.demo.services;

import tn.esprit.demo.entities.Equipe;

import java.util.List;

public interface IEquipeService  {
    public Equipe addEquipe(Equipe equipe);

    public List<Equipe> retrieveAllEquipes();
    public Equipe retrieveEquipe (Long idEquipe);
    public Equipe updateEquipe (Equipe equipe);
    public Equipe addEquipeAndAssign(Equipe equipe);
    public  void deleteEquipe(Long idEquipe);

}
