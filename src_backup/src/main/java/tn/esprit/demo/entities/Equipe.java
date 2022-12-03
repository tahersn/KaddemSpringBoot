package tn.esprit.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Equipe")
@RequiredArgsConstructor
@AllArgsConstructor


public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipe")
    private long idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy ="Equipes")
    private Set<Etudiant> etudiants;
    @OneToOne
    private DetailEquipe detailEquipe_pk;
}
