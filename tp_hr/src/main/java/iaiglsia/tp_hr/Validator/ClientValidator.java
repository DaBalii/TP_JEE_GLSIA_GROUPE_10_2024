package iaiglsia.tp_hr.Validator;

import iaiglsia.tp_hr.entity.client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@AllArgsConstructor
@Service
@Getter
@Setter
@Component

public class ClientValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return client.class.equals(clazz);
    }


    public void validate(Object target, Errors errors) {
        client client = (client) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "field.required", "Le nom est obligatoire.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateNaissance", "field.required", "La date de naissance est obligatoire.");
        if (client.getDateNaissance() != null && client.getDateNaissance().isAfter(LocalDate.now())) {
            errors.rejectValue("dateNaissance", "field.invalid", "La date de naissance ne peut pas être dans le futur.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courriel", "field.required", "L'adresse email est obligatoire.");
        if (client.getCourriel() != null && !client.getCourriel().contains("@")) {
            errors.rejectValue("courriel", "field.invalid", "L'adresse email doit contenir @.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sexe", "field.required", "Le sexe est obligatoire.");
        String sexe = client.getSexe();
        if (sexe != null && !(sexe.equals("F") || sexe.equals("M"))) {
            errors.rejectValue("sexe", "field.invalid", "Le sexe doit être 'F' ou 'M'.");
        }
    }
}
