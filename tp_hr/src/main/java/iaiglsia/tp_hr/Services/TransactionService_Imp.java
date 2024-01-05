package iaiglsia.tp_hr.Services;

import iaiglsia.tp_hr.Repository.TransactionRepository;
import iaiglsia.tp_hr.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService_Imp implements TransactionService{

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService_Imp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Override
    public List<Transaction> findByCompteIdAndDateBetween(Long compteId, LocalDate startDate, LocalDate endDate) {
        System.out.println("Recherche de transactions pour le compte " + compteId + " entre " + startDate + " et " + endDate);
        List<Transaction> transactions = transactionRepository.findByCompteIdAndDateBetween(compteId, startDate, endDate);
        System.out.println("Transactions trouvées : " + transactions);
        return transactions;
    }

    @Override
    public List<Transaction> getTransactionsByClientId(Long id) {
        return transactionRepository.findByCompte_Proprietaire_Id(id);

    }


}
