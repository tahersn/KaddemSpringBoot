package tn.esprit.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "DetailEquipe")
public class DetailEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetailEquipe")
    private long idDetailEquipe;
    private Integer salle;
    private String thematique;
    @OneToOne(mappedBy = "detailEquipe_pk")
    private Equipe equipe;
}
