package tn.esprit.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "competence")
@AllArgsConstructor
@RequiredArgsConstructor
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long idCompetence;
    private String nomCompetnce;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private NiveauCompetence NiveauC;
    @ManyToMany( cascade = CascadeType.ALL,mappedBy ="Competences")
    private Set<Etudiant> etudiants;



}
