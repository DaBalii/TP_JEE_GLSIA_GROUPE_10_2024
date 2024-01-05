package iaiglsia.tp_hr.Controller;

import iaiglsia.tp_hr.Services.TransactionService;
import iaiglsia.tp_hr.entity.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/impression")
public class ReleveController {

    private final TransactionService transactionService;

    public ReleveController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/releve/{id}")
    public String telechargerReleveHtml(@PathVariable Long id, Model model) {
        List<Transaction> transactions = transactionService.getTransactionsByClientId(id);

        if (!transactions.isEmpty()) {
            model.addAttribute("transactions", transactions);
        } else {
            model.addAttribute("transactions", new ArrayList<>());
        }

        return "releve";
    }
}
