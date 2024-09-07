package utils.security;

import lombok.Setter;

@Setter
public class ValidadorContraseniaOWASP {
    private ComprobadorRecomendacionesOWASP comprobadorOWASP;

    public ValidadorContraseniaOWASP() {
        this.comprobadorOWASP = new ComprobadorRecomendacionesOWASP();
    }
    public boolean esContraseniaSeguraRecomendada(String password) {
        return this.comprobadorOWASP.validarContrasenia(password);
    }

    public void aniadirRecomendaciones(ComprobadorRecomendacionesOWASP comprobadorRecomendacionesOWASP) {
        this.comprobadorOWASP = comprobadorRecomendacionesOWASP;
    }

}
