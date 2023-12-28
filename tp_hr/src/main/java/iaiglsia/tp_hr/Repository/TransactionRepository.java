package iaiglsia.tp_hr.Repository;

import iaiglsia.tp_hr.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByCompteIdAndDateBetween(Long compteId, LocalDate startDate, LocalDate endDate);
}

