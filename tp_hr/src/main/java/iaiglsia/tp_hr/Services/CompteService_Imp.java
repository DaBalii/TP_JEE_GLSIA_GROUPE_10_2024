package iaiglsia.tp_hr.Services;

import iaiglsia.tp_hr.Repository.CompteRepository;
import iaiglsia.tp_hr.entity.compte;
import lombok.AllArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompteService_Imp implements CompteService{

    private CompteRepository compteRepository;
    @Override
    public List<compte> getAllComptes() {
        return compteRepository.findAll();
    }

    @Override
    public compte getCompteById(Long id) {

        return compteRepository.findById(id).orElse(null);
    }

    @Override
    public compte createCompte(compte compte) {
        compte.setSolde(0.0);
        String generatedIban = generateIban();
        compte.setNumeroCompte(generatedIban);
        return compteRepository.save(compte);
    }

    @Override
    public compte updateCompte(Long id, compte Compte) {
        return compteRepository.findById(id)
                .map(c ->{
                    c.setSolde(Compte.getSolde());
                    c.setProprietaire(Compte.getProprietaire());
                    c.setTypeCompte(Compte.getTypeCompte());
                    return compteRepository.save(c);
                }).orElseThrow(() ->new RuntimeException("compte non modifier..."));
    }

    @Override
    public String deleteCompte(Long id) {
        compteRepository.deleteById(id);
        return "compte supprimer avec succès";

    }

    private String generateIban() {
        Iban iban = new Iban.Builder()
                .countryCode(CountryCode.FR)
                .bankCode("12345")
                .branchCode("67890")
                .accountNumber("ABCDEFGHIJK")
                .nationalCheckDigit("67")
                .build();

        return iban.toString();
    }
}
