package utils.security;



import java.util.ArrayList;

public class MetodoDeLasCredencialesPorDefecto implements CriterioDeValidacionDeContrasenia {
    public MetodoDeLasCredencialesPorDefecto() {}

    public boolean validarContrasenia(String password) {
        ArrayList<String> credencialesPorDefecto = new ArrayList<>();
        credencialesPorDefecto.add("admin");
        credencialesPorDefecto.add("administrador");
        credencialesPorDefecto.add("user");
        credencialesPorDefecto.add("usuario");
        for(String credencial : credencialesPorDefecto){
            if(password.contains(credencial)){
                return false;
            }
        }
        return true;
    }
}
