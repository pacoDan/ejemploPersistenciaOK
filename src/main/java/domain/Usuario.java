package domain;

import lombok.Getter;
import utils.security.ComprobadorRecomendacionesOWASP;
import utils.security.ValidadorContraseniaOWASP;

import java.util.Scanner;

@Getter
public class Usuario {
    private String nombreUsuario;
    private String nombre;
    private String contrasenia;


    public Usuario(String nombreUsuario, String nombre) {
        this.nombreUsuario = nombreUsuario;
        this.nombre =nombre;
        this.contrasenia = GeneradorContrasenia.generarContrasenia();

    }
    public void modificarContrasenia(String nuevaContrasenia){
        ValidadorContraseniaOWASP validador = new ValidadorContraseniaOWASP();
        ComprobadorRecomendacionesOWASP comprobador = new ComprobadorRecomendacionesOWASP();
        validador.setComprobadorOWASP(comprobador);

        while(!validador.esContraseniaSeguraRecomendada(nuevaContrasenia)){
            Scanner scanner = new Scanner(System.in);
            System.out.println("No es una contraseña segura, reescriba otra");
            nuevaContrasenia = scanner.nextLine();
        }
        this.contrasenia = nuevaContrasenia;
    }

}
