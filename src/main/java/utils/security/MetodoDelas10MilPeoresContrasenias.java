package utils.security;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MetodoDelas10MilPeoresContrasenias implements CriterioDeValidacionDeContrasenia {
    private static final String PASSWORDS_FILE_PATH = "src/main/resources/10-million-password-list-top-10000.txt";
    private static final Set<String> WORST_PASSWORDS = new HashSet<>();

    public MetodoDelas10MilPeoresContrasenias() {
        loadPasswords();
    }

    // Método para leer el archivo de contraseñas y cargarlas en el conjunto
    private static void loadPasswords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PASSWORDS_FILE_PATH))) {
            String password;
            while ((password = reader.readLine()) != null) {
                WORST_PASSWORDS.add(password.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean validarContrasenia(String password) {
        return !WORST_PASSWORDS.contains(password);
    }
}
