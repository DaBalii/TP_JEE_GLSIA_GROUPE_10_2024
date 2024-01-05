package iaiglsia.tp_hr.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Table(name = "Comptes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String numeroCompte;
    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;
    private LocalDate dateCreation;
    private double solde;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private client proprietaire;

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", proprietaireId=" + (proprietaire != null ? proprietaire.getId() : null) +
                '}';
    }




}
