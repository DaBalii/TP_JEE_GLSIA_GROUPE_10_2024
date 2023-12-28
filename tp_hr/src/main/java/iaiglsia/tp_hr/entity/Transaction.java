package iaiglsia.tp_hr.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private double montant;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private compte compte;
}
