package tn.esprit.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtudiant")
    private Long idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @OneToMany( cascade = CascadeType.ALL,mappedBy = "etudiant")
    @JsonIgnore
     Set<Contrat> Contrats;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnore
     Set<Equipe> Equipes;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
     Departement departement;


}
