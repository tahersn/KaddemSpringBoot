package tn.esprit.demo.entities;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
@Builder
public class Societe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idS;
    private String nomS;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "societe")
    private List<Encadrant> encadrantList;


}

