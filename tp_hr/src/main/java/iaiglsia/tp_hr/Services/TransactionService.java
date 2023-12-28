package iaiglsia.tp_hr.Services;

import iaiglsia.tp_hr.entity.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
    List<Transaction> findByCompteIdAndDateBetween(Long compteId, LocalDate startDate, LocalDate endDate);
}
