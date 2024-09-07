package colaboraciones.HacerseCargoDeHeladera;

import models.entities.Heladera.Punto;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class ReconmendadorDePuntosIdealesAPI implements AdapterReconmendadorDePuntosIdeales {
    private ApiService apiService;

    public ReconmendadorDePuntosIdealesAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://19ce5103-2540-4d0e-9acb-e471ff40878b.mock.pstmn.io/")  
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    @Override
    public List<Punto> obtenerPuntosColocacion(Punto punto, double radio) {
        Call<List<Punto>> call = apiService.obtenerPuntosColocacion(punto.getLatitud(), punto.getLongitud(), radio);
        try {
            Response<List<Punto>> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Error al obtener los puntos de colocación: " + response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

