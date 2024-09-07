package colaboraciones.HacerseCargoDeHeladera;

import models.entities.Heladera.Punto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface ApiService {
    @GET("api/puntosRecomendados/1")
    Call<List<Punto>> obtenerPuntosColocacion(
            @Query("latitud") double latitud,
            @Query("longitud") double longitud,
            @Query("radio") double radio
    );
}