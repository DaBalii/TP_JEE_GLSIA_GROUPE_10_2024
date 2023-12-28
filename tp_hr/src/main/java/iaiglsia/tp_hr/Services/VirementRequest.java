package iaiglsia.tp_hr.Services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class VirementRequest {
    private Long idCompteSource;
    private Long idCompteDestination;
    private double montant;
}
