package models.entities.Notificador.Medios;

import models.entities.Notificador.Notificacion;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class AdapterTelegram implements AdapterNotificacionTelegram {

    private static final String BOT_TOKEN = "7305621574:AAFO6dF-9mlRmmZhO_2Oy74_9gaB_D4esIc";
    private static final String TELEGRAM_API_URL = "https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage";

    public void notificar(Notificacion notificacion) {
        String chatId = "6890895462";
        String mensaje = notificacion.getMensaje();

        try {
            enviarMensaje(chatId, mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enviarMensaje(String chatId, String mensaje) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String url = TELEGRAM_API_URL + "?chat_id=" + URLEncoder.encode(chatId, StandardCharsets.UTF_8.toString()) + "&text=" + URLEncoder.encode(mensaje, StandardCharsets.UTF_8.toString());

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Consume the response to ensure the connection is closed properly
            try (ResponseBody responseBody = response.body()) {
                if (responseBody != null) {
                    System.out.println(responseBody.string());
                }
            }
        }
    }
}
