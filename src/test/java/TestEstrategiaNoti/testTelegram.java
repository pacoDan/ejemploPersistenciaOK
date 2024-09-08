package TestEstrategiaNoti;

import domain.Colaborador;
import domain.DatosPersonales;
import domain.Usuario;
import models.entities.Notificador.Medios.AdapterTelegram;
import models.entities.Notificador.Notificacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class testTelegram{

    @Mock
    private AdapterTelegram adapterTelegram;

    private Notificacion notificacion;
    private Colaborador colaborador;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        DatosPersonales datosPersonales = new DatosPersonales("Juan Perez", "vveron@frba.utn.edu.ar", "+","ver", "valen.veron8@gmail.com","");
        colaborador = new Colaborador(datosPersonales, new Usuario("usuario", "password"));
        notificacion = new Notificacion("Mensaje de prueba", colaborador);
    }

    @Test
    public void testNotificar() {
        // Act
        adapterTelegram.notificar(notificacion);

        // Assert
        ArgumentCaptor<Notificacion> argumentCaptor = ArgumentCaptor.forClass(Notificacion.class);
        verify(adapterTelegram).notificar(argumentCaptor.capture());
        Notificacion capturedNotificacion = argumentCaptor.getValue();

        Assertions.assertEquals("Mensaje de prueba", capturedNotificacion.getMensaje());
        Assertions.assertEquals(colaborador, capturedNotificacion.getReceptor());
    }
}

