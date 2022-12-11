package tn.esprit.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employe")
@Getter
@Setter
public class Employe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmp")

    private Integer idEmp;
    private String firstName;
    private String lastName;
    private Integer solde;
    @ManyToOne
    Departement departement;
}
