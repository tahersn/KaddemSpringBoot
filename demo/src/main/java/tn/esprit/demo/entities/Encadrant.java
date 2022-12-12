package tn.esprit.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Encadrant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnc;
    private String nomEnc;
    private String prenomEnc;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "encadrant")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Contrat> contrats;

    @ManyToOne
    private Societe societe;
}
