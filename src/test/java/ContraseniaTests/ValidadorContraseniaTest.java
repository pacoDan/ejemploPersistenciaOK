package ContraseniaTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.security.ValidadorContraseniaOWASP;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidadorContraseniaTest {
    ValidadorContraseniaOWASP clienteValidador ;

    @BeforeEach
    void setUp() {
        clienteValidador = new ValidadorContraseniaOWASP();
    }
    @Test
    @DisplayName("123 NO es contrasenia segura")
    void comprobarMalaContrasenia() {
        assertFalse(clienteValidador.esContraseniaSeguraRecomendada("123"));
    }
    @Test
    @DisplayName("\"123!Buenas\" SI es contrasenia segura")
    void comprobarContrasenia() {
        var password="123!Buenas";
        assertTrue(clienteValidador.esContraseniaSeguraRecomendada(password));
    }
}