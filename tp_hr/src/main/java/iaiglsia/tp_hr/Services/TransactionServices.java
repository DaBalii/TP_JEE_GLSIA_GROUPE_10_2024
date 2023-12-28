package iaiglsia.tp_hr.Services;

import iaiglsia.tp_hr.Repository.TransactionRepository;
import iaiglsia.tp_hr.entity.Transaction;
import iaiglsia.tp_hr.entity.TransactionType;
import iaiglsia.tp_hr.entity.compte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
@Setter
@Service
public class TransactionServices {
    private TransactionRepository transactionRepository;
    public Transaction enregistrerTransaction(compte compte, TransactionType type, double montant) {
        Transaction transaction = new Transaction();
        transaction.setCompte(compte);
        transaction.setType(type);
        transaction.setMontant(montant);
        transaction.setDate(LocalDate.now());

        transactionRepository.save(transaction);

        return transaction;
    }
}
