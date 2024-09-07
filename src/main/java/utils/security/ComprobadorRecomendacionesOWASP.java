package utils.security;

import java.util.ArrayList;
import java.util.List;

public class ComprobadorRecomendacionesOWASP {
    private List<CriterioDeValidacionDeContrasenia> criteriosACumplir;
    public ComprobadorRecomendacionesOWASP() {
        this.criteriosACumplir= new ArrayList<CriterioDeValidacionDeContrasenia>();
        this.criteriosACumplir.add(new MetodoDelas10MilPeoresContrasenias());
        this.criteriosACumplir.add(new MetodoDeLasCredencialesPorDefecto());
    }
    public boolean validarContrasenia(String password) {
        return this.criteriosACumplir.stream().allMatch(unMetodo-> unMetodo.validarContrasenia(password));
    }
}
