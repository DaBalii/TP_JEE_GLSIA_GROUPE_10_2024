package iaiglsia.tp_hr.Controller;

import iaiglsia.tp_hr.Services.CompteService;
import iaiglsia.tp_hr.entity.compte;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comptes")
public class CompteController {
    @Autowired
    private CompteService compteService;

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

}
