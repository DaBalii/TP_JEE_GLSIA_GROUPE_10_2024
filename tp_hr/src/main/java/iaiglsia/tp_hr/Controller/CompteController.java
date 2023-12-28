package iaiglsia.tp_hr.Controller;

import iaiglsia.tp_hr.Services.CompteService;
import iaiglsia.tp_hr.Services.MontantRequest;
import iaiglsia.tp_hr.Services.TransactionService;
import iaiglsia.tp_hr.Services.VirementRequest;
import iaiglsia.tp_hr.entity.Transaction;
import iaiglsia.tp_hr.entity.compte;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comptes")
public class CompteController {
    @Autowired
    private CompteService compteService;
    private TransactionService transactionService;




    @GetMapping
    public List<compte> getAllComptes() {
        return compteService.getAllComptes();
    }

    @GetMapping("/{id}")
    public compte getCompteById(@PathVariable Long id) {
        return compteService.getCompteById(id);
    }

    @PostMapping("/create")
    public compte createCompte(@RequestBody compte compte) {
        return compteService.createCompte(compte);
    }

    @PutMapping("/update/{id}")
    public compte updateCompte(@PathVariable Long id, @RequestBody compte Compte) {
        return compteService.updateCompte(id, Compte);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCompte(@PathVariable Long id) {
        compteService.deleteCompte(id);
        return "compte supprimer avec succès";

    }

    @PostMapping("/depot/{id}")
    public ResponseEntity<String> faireVersement(@PathVariable Long id, @RequestBody MontantRequest montantRequest) {
        String message = compteService.faireVersement(id, montantRequest.getMontant());
        return ResponseEntity.ok(message);
    }


    @PostMapping("/retrait/{id}")
    public void faireRetrait(@PathVariable Long id,@RequestBody MontantRequest montantRequest){
        compteService.faireRetrait(id,montantRequest.getMontant());
    }


    @PostMapping("/transis")
    public ResponseEntity<String> faireVirement(@RequestBody VirementRequest virementRequest) {
        Long idCompteSource = virementRequest.getIdCompteSource();
        Long idCompteDest = virementRequest.getIdCompteDestination();
        double montant = virementRequest.getMontant();

        try {
            compteService.faireVirement(idCompteSource, idCompteDest, montant);
            return ResponseEntity.ok("Virement de " + montant + " effectué avec succès.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{compteId}/transactions")
    public List<Transaction> getTransactionsByCompteAndDate(
            @PathVariable Long compteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return transactionService.findByCompteIdAndDateBetween(compteId, startDate, endDate);
    }

}
