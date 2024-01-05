package iaiglsia.tp_hr.Services;

import iaiglsia.tp_hr.Repository.CompteRepository;
import iaiglsia.tp_hr.Repository.TransactionRepository;
import iaiglsia.tp_hr.entity.Transaction;
import iaiglsia.tp_hr.entity.TransactionType;
import iaiglsia.tp_hr.entity.compte;
import lombok.AllArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class CompteService_Imp implements CompteService{


    private CompteRepository compteRepository;
    private TransactionServices transactionServices;
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

        LocalDate dateCreation = compte.getDateCreation();
        if (dateCreation == null || !dateCreation.isEqual(LocalDate.now())) {
            throw new RuntimeException("La date de création doit être la date actuelle.");
        }

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





    public String generateIban() {
        SecureRandom random = new SecureRandom();

        String bban = generateRandomAlphaNumericString(23, random);

        Iban iban = new Iban.Builder()
                .countryCode(CountryCode.FR)
                .bankCode("12345")
                .branchCode("67890")
                .accountNumber(bban.substring(0, 11))
                .nationalCheckDigit(generateRandomNumericString(2, random))
                .build();

        return iban.toString();
    }


    private String generateRandomAlphaNumericString(int length, SecureRandom random) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }

        return result.toString();
    }

    private String generateRandomNumericString(int length, SecureRandom random) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            result.append(random.nextInt(10));
        }

        return result.toString();
    }



    public String faireVersement(Long id, double montant) {
        compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé."));

        double nouveauSolde = compte.getSolde() + montant;
        compte.setSolde(nouveauSolde);
        compteRepository.save(compte);
        transactionServices.enregistrerTransaction(compte, TransactionType.Versement, montant);

        return "Versement de " + montant + " effectué avec succès. Nouveau solde : " + nouveauSolde;
    }


    public void faireRetrait(Long id, double montant) {
        compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé."));

        double soldeActuel = compte.getSolde();
        if (soldeActuel >= montant) {
            double nouveauSolde = soldeActuel - montant;
            compte.setSolde(nouveauSolde);
            compteRepository.save(compte);
            transactionServices.enregistrerTransaction(compte, TransactionType.Retrait, montant);
        } else {
            throw new RuntimeException("Solde insuffisant pour effectuer le retrait.");
        }
    }

    public void faireVirement(Long idCompteSource, Long idCompteDest, double montant) {

        compte compteSource = compteRepository.findById(idCompteSource)
                .orElseThrow(() -> new RuntimeException("Compte source non trouvé."));

        compte compteDest = compteRepository.findById(idCompteDest)
                .orElseThrow(() -> new RuntimeException("Compte destination non trouvé."));

        double soldeSource = compteSource.getSolde();
        if (soldeSource >= montant) {
            double nouveauSoldeSource = soldeSource - montant;
            compteSource.setSolde(nouveauSoldeSource);

            double nouveauSoldeDest = compteDest.getSolde() + montant;
            compteDest.setSolde(nouveauSoldeDest);

            compteRepository.save(compteSource);
            transactionServices.enregistrerTransaction(compteSource, TransactionType.Virement, montant);
            compteRepository.save(compteDest);
        } else {
            throw new RuntimeException("Solde insuffisant pour effectuer le virement.");
        }
    }
}
