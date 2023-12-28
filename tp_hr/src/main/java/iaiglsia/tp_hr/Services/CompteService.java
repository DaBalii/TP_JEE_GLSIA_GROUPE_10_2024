package iaiglsia.tp_hr.Services;

import iaiglsia.tp_hr.entity.Transaction;
import iaiglsia.tp_hr.entity.compte;

import java.time.LocalDate;
import java.util.List;

public interface CompteService {

    public List<compte> getAllComptes();

    public compte getCompteById(Long id);

    public compte createCompte(compte compte);

    public compte updateCompte(Long id, compte updatedCompte);

    public String deleteCompte(Long id);

    public String faireVersement(Long id, double montant);

    public void faireRetrait(Long id, double montant);

    public void faireVirement(Long idCompteSource, Long idCompteDest, double montant);

}
