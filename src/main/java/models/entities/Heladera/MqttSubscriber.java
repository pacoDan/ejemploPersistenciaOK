package models.entities.Heladera;

import Incidentes.*;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MqttSubscriber {

    private static final String BROKER_URL = "tcp://localhost:1883";
    private static final String TOPIC_TEMPERATURE = "heladera/temperatura";

    // Simulación de base de datos en memoria para heladeras
    private static Map<Long, Heladera> heladeras = new HashMap<>();

    public static void main(String[] args) {
        String clientId = "JavaClient1";

        try {
            MqttClient client = new MqttClient(BROKER_URL, clientId, new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);

            System.out.println("Conectándose al broker: " + BROKER_URL);
            client.connect(options);
            System.out.println("Conectado al broker");

            // Suscripción al tema de temperaturas
            client.subscribe(TOPIC_TEMPERATURE, (topic, message) -> {
                String payload = new String(message.getPayload());
                System.out.println("Mensaje de temperatura recibido: " + payload);
                // Procesar el mensaje recibido
                procesarTemperatura(payload);
            });

            // Esperar indefinidamente para recibir mensajes
            while (true) {
                Thread.sleep(1000);
            }

        } catch (MqttException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void procesarTemperatura(String payload) {
        // Parsear el mensaje para obtener la información de la temperatura
        String[] datos = payload.split(",");
        Long idHeladera = Long.parseLong(datos[0]);
        Double valorTemperatura = Double.parseDouble(datos[1]);

        // Buscar la heladera correspondiente
        Heladera heladera = heladeras.get(idHeladera);

        if (heladera != null) {
            // Actualizar la temperatura
            Temperatura nuevaTemperatura = new Temperatura(valorTemperatura, LocalDateTime.now());
            heladera.getSensorDeTemperatura().setTemperaturaActual(nuevaTemperatura);
            heladera.getSensorDeTemperatura().getMediciones().add(nuevaTemperatura);
            heladera.setUltTemperatura(nuevaTemperatura);

            // Verificar si la temperatura está dentro del rango aceptable
            if (valorTemperatura < heladera.getTemperaturaMinima().getValor()) {
                // Marcar la heladera como inactiva y registrar un incidente de temperatura baja
                heladera.marcarComoInactiva();
                Incidente incidente = crearIncidente(heladera, TipoAlerta.TEMPERATURA_BAJA);
                heladera.agregarIncidente(incidente);
                System.out.println("Heladera " + idHeladera + " marcada como inactiva por alerta de temperatura baja.");
            } else if (valorTemperatura > heladera.getTemperaturaMaxima().getValor()) {
                // Marcar la heladera como inactiva y registrar un incidente de temperatura alta
                heladera.marcarComoInactiva();
                Incidente incidente = crearIncidente(heladera, TipoAlerta.TEMPERATURA_ALTA);
                heladera.agregarIncidente(incidente);
                System.out.println("Heladera " + idHeladera + " marcada como inactiva por alerta de temperatura alta.");
            }

            System.out.println("Temperatura de Heladera " + idHeladera + " actualizada a " + valorTemperatura);
        } else {
            System.out.println("Heladera con ID " + idHeladera + " no encontrada.");
        }
    }

    private static Incidente crearIncidente(Heladera heladera, TipoAlerta tipoAlerta) {
        Incidente incidente = new Incidente();
        incidente.setFechaYHora(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        incidente.setHeladera(heladera);
        incidente.setTipoIncidente(TipoIncidente.ALERTA);
        incidente.setEstadoIncidente(EstadoIncidente.PENDIENTE);

        Alerta alerta = new Alerta(tipoAlerta);
        alerta.evaluar(heladera);
        incidente.setAlerta(alerta);

        return incidente;
    }
}
