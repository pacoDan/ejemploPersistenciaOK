package tarjetaTests;

import models.entities.PersonaEnSituacionVulnerable;
import models.entities.Tarjeta;
import models.entities.UsoTarjeta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class usoTarjetaTest {
      private PersonaEnSituacionVulnerable persona;
      private PersonaEnSituacionVulnerable menor1;
      private PersonaEnSituacionVulnerable menor2;
      private PersonaEnSituacionVulnerable menorACargoQueYaEsMayor;
      private Tarjeta tarjeta;
      private UsoTarjeta uso1;
      private UsoTarjeta uso2;

@BeforeEach
public void setUp() {
    persona = new PersonaEnSituacionVulnerable();
    menor1 = new PersonaEnSituacionVulnerable();
    menor2 = new PersonaEnSituacionVulnerable();
    menorACargoQueYaEsMayor = new PersonaEnSituacionVulnerable();
    tarjeta = new Tarjeta(persona);
    menor1.setFechaNacimiento(LocalDate.now());
    menor2.setFechaNacimiento(LocalDate.now());
    uso1 = new UsoTarjeta(tarjeta, LocalDateTime.now());
    uso2 = new UsoTarjeta(tarjeta, LocalDateTime.now());
    tarjeta.getUsos().add(uso1);
    tarjeta.getUsos().add(uso2);
    LocalDate fecha = LocalDate.of(2002,5,29);
    menorACargoQueYaEsMayor.setFechaNacimiento(fecha);
}

 @Test
 public void verificarCalculoDeUsosDiarios(){
  persona.getMenoresACargo().add(menor1);
  persona.getMenoresACargo().add(menor2);
  persona.getMenoresACargo().add(menorACargoQueYaEsMayor);
  Assertions.assertEquals(8,tarjeta.getCantidadViandasDisponiblesPorDia());

 }

 @Test
 public void verificarPuedeUsarse(){
     Assertions.assertTrue(tarjeta.puedeUsarse(),"");
 }

 @Test
 public void verificarNoPuedeUsarse() {
     tarjeta.getUsos().add(uso1);
     tarjeta.getUsos().add(uso2);
     Assertions.assertFalse(tarjeta.puedeUsarse(), "");
 }
}
