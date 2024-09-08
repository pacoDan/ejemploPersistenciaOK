package domain;


import colaboraciones.DistribuirVianda.DistribuirVianda;
import colaboraciones.DonacionDeDinero.DonacionDeDinero;
import colaboraciones.DonacionVianda.DonacionVianda;
import colaboraciones.EntregarTarjeta.RegistrarPersona;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class lectorCSV {
    public enum TipoDocumento {
        DNI,
        LC,
        LE
    }

    public enum FormaColaboracion {
        DINERO,
        DONACION_VIANDAS,
        REDISTRIBUCION_VIANDAS,
        ENTREGA_TARJETAS
    }

    public lectorCSV(String separador) {
        this.separador = separador;
    }

    private String separador = ",";
    @Getter
    private Map<String, Object> colaboraciones = new HashMap<>();

    public void lector(String pathArchivo) throws FileNotFoundException, RuntimeException {
        String[] linea = null;
        HashMap<String, Colaborador> colaboradorMap = new HashMap<>();
        CSVReader csvReader = new CSVReader(new FileReader(pathArchivo));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {

            while ((linea = csvReader.readNext()) != null) {
                if (!esRegistroValido(linea)) {
                    continue;
                }
                String tipoDoc = linea[0];
                String documento = linea[1];
                String nombre = linea[2];
                String apellido = linea[3];
                String mail = linea[4];
                Date fechaColaboracion = sdf.parse(linea[5]);
                String formaColaboracion = linea[6];
                Integer cantidad = Integer.parseInt(linea[7]);
                Colaborador colaborador;

                String key = tipoDoc + documento;
                if (colaboradorMap.get(key) == null) {
                    DatosPersonales datosPersonales = new DatosPersonales(tipoDoc, documento, nombre, apellido, mail, null);
                    Usuario usuario = new Usuario(mail, nombre);
                    colaborador = new Colaborador(datosPersonales, usuario);
                    colaboradorMap.put(key, colaborador);
                    enviarCorreo(colaborador);
                }

                colaborador = colaboradorMap.get(key);
                String colaboracionKey = key + sdf.format(fechaColaboracion);

                switch (formaColaboracion) {
                    case "DINERO":
                        DonacionDeDinero donacionDeDinero = new DonacionDeDinero(fechaColaboracion, cantidad, colaborador);
                        colaboraciones.put(colaboracionKey, donacionDeDinero);
                        break;
                    case "DONACION_VIANDAS":
                        DonacionVianda donacionVianda = new DonacionVianda(fechaColaboracion, cantidad, colaborador, null);
                        colaboraciones.put(colaboracionKey, donacionVianda);
                        break;
                    case "REDISTRIBUCION_VIANDAS":
                        DistribuirVianda distribuirVianda = new DistribuirVianda(fechaColaboracion, cantidad, null, null);
                        colaboraciones.put(colaboracionKey, distribuirVianda);
                        break;
                    case "ENTREGA_TARJETAS":
                        RegistrarPersona entregarTarjeta = new RegistrarPersona(fechaColaboracion, cantidad, colaborador);
                        colaboraciones.put(colaboracionKey, entregarTarjeta);
                        break;
                    default:
                        throw new IllegalArgumentException("Colaboracion no valida");
                }
            }

            csvReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException | ParseException e) {
            throw new RuntimeException(e);
        }

    }

    private boolean esRegistroValido(String[] linea) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(linea[5]);
        } catch (ParseException e) {
            return false;
        }
        try {
            TipoDocumento tipoDocumento = TipoDocumento.valueOf(linea[0]);
        } catch (IllegalArgumentException e) {
            return false;
        }
        try {
            FormaColaboracion colaboracion = FormaColaboracion.valueOf(linea[6]);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private void enviarCorreo(Colaborador colaborador) {
        String destinatario = colaborador.getDatosPersonales().getMail();
        String asunto = "Agradecimiento por colaboracion";
        String mensaje = "\"Estimado " + colaborador.getDatosPersonales().getNombre() + " \n Gracias por tu colaboracion, te creamos una " +
                "cuenta\n" +
                " Tus credenciales de acceso son:\" \n" +
                "Usuario: " + colaborador.getUsuario().getNombreUsuario() +
                "\n Contrasenia :" + colaborador.getUsuario().getContrasenia() +
                " \n Por favor ingrese al sistema y verifique los datos";
        EnviadorMail enviador = new EnviadorMail();
        enviador.enviarConGMail(destinatario, asunto, mensaje);


    }

}

