package db;


import io.github.flbulgarelli.jpa.extras.test.SimplePersistenceTest;
import main.MainExample;
import models.repositories.RepositorioDeServicios;
import org.junit.jupiter.api.Test;
import services.ServiceServicio;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContextTest implements SimplePersistenceTest {
  ServiceServicio serviceServicio; //= new ServiceServicio();
  @Test
  void contextUp() {
    assertNotNull(entityManager());
  }
  
  @Test
  void contextUpWithTransaction() throws Exception {
    withTransaction(() -> {
      serviceServicio= new ServiceServicio();

      serviceServicio.guardarServicios();
      serviceServicio.recuperarServicios();
      serviceServicio.agregarTareasAServicios();

      serviceServicio.recuperarServicios2();
      serviceServicio.actualizarNombreDeServicios();
    });
  }

}
