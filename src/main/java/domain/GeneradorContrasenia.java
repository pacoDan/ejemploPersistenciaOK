package domain;

import utils.security.ComprobadorRecomendacionesOWASP;
import utils.security.ValidadorContraseniaOWASP;

import java.security.SecureRandom;

public class GeneradorContrasenia {
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+<>?";
    private static final String ALL_CHARACTERS = UPPER_CASE + LOWER_CASE + DIGITS + SPECIAL_CHARACTERS;

    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generarContrasenia() {

        Integer length = RANDOM.nextInt(5) + 8;

        StringBuilder contrasenia = new StringBuilder(length);


        contrasenia.append(UPPER_CASE.charAt(RANDOM.nextInt(UPPER_CASE.length())));
        contrasenia.append(LOWER_CASE.charAt(RANDOM.nextInt(LOWER_CASE.length())));
        contrasenia.append(DIGITS.charAt(RANDOM.nextInt(DIGITS.length())));
        contrasenia.append(SPECIAL_CHARACTERS.charAt(RANDOM.nextInt(SPECIAL_CHARACTERS.length())));

        for (int i = 4; i < length; i++) {
            contrasenia.append(ALL_CHARACTERS.charAt(RANDOM.nextInt(ALL_CHARACTERS.length())));
        }

        char[] passwordArray = contrasenia.toString().toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int randomIndex = RANDOM.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }

        String generatedPassword = new String(passwordArray);
        ValidadorContraseniaOWASP validador = new ValidadorContraseniaOWASP();
        ComprobadorRecomendacionesOWASP comprobador = new ComprobadorRecomendacionesOWASP();
        validador.setComprobadorOWASP(comprobador);
        if (!validador.esContraseniaSeguraRecomendada(generatedPassword)) {
            return generarContrasenia();
        }
        return generatedPassword;
    }}