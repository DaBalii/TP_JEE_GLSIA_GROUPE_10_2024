package iaiglsia.tp_hr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "Clients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String sexe;
    private String adresse;
    private String numeroTelephone;
    private String courriel;
    private String nationalite;

    @OneToMany(mappedBy = "proprietaire")
    @JsonIgnore
    private List<compte> comptes;


    @Override
    public String toString() {
        return "Client{" +
                "client_id=" + id +
                ", nom='" + nom + '\'' +
                // Ajoutez d'autres propriétés ici
                '}';
    }




}
