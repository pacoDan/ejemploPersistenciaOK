package main;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import models.entities.servicios.Servicio;
import models.entities.servicios.Tarea;
import models.repositories.RepositorioDeServicios;

import java.util.List;
import java.util.Optional;

public class MainExample implements WithSimplePersistenceUnit {
    private RepositorioDeServicios repositorioDeServicios;

    public static void main(String[] args) {
        MainExample instance = new MainExample();
        instance.repositorioDeServicios = new RepositorioDeServicios();

        instance.guardarServicios();
        instance.recuperarServicios();
        instance.agregarTareasAServicios();

        instance.recuperarServicios2();
        instance.actualizarNombreDeServicios();
    }

    private void guardarServicios() {
        /*Servicio servicio1 = new Servicio();
        servicio1.setNombre("Abogacia");

        Servicio servicio2 = new Servicio();
        servicio2.setNombre("Ingenieria en Sistemas");

        beginTransaction();
        repositorioDeServicios.guardar(servicio1);
        repositorioDeServicios.guardar(servicio2);
        commitTransaction();*/

        withTransaction(() -> {
            Servicio servicio1 = new Servicio();
            servicio1.setNombre("Abogacia");

            Servicio servicio2 = new Servicio();
            servicio2.setNombre("Ingenieria en Sistemas");

            repositorioDeServicios.guardar(servicio1);
            repositorioDeServicios.guardar(servicio2);
        });
    }

    private void recuperarServicios() {
        Optional<Servicio> posibleServicio1 = this.repositorioDeServicios.buscarPorId(1L);
        if(posibleServicio1.isPresent()) {
            Servicio servicio1 = posibleServicio1.get();
            System.out.println(servicio1);
        }

        /*Servicio servicio1bis = this.repositorioDeServicios.buscarPorId2(1L);

        if(servicio1bis != null) {

        }*/

        List<Servicio> servicios = this.repositorioDeServicios.buscarPorNombre("Ingenieria en Sistemas");

        if(!servicios.isEmpty()) {
            Servicio servicio2 = servicios.get(0);
            System.out.println(servicio2);
        }

    }

    private void recuperarServicios2() {
        List<Servicio> servicios = this.repositorioDeServicios.buscarTodos();
        System.out.println(servicios);
    }

    private void actualizarNombreDeServicios() {
        List<Servicio> servicios = this.repositorioDeServicios.buscarPorNombre("Ingenieria en Sistemas");

        if(!servicios.isEmpty()) {
            Servicio servicio1 = servicios.get(0);
            servicio1.setNombre("Ing. en Sistemas");
            this.repositorioDeServicios.modificar(servicio1);
        }

        List<Servicio> servicios2 = this.repositorioDeServicios.buscarPorNombre("Abogacia");

        if(!servicios2.isEmpty()) {
            Servicio servicio2 = servicios2.get(0);
            servicio2.setNombre("Abogacía");
            this.repositorioDeServicios.modificar(servicio2);
        }
    }

    private void agregarTareasAServicios() {
        Optional<Servicio> posibleServicio1 = this.repositorioDeServicios.buscarPorId(1L);

        if(posibleServicio1.isPresent()) {
            Servicio servicio1 = posibleServicio1.get();
            servicio1.agregarTareas(
                    Tarea.builder().nombre("Lectura del caso").build(),
                    Tarea.builder().nombre("Presentación judicial").build()
            );
            this.repositorioDeServicios.modificar(servicio1);
        }

        Optional<Servicio> posibleServicio2 = this.repositorioDeServicios.buscarPorId(2L);

        if(posibleServicio2.isPresent()) {
            Servicio servicio2 = posibleServicio2.get();
            servicio2.agregarTareas(
                    Tarea.builder().nombre("Testing de Software").build(),
                    Tarea.builder().nombre("Diseño del modelo de datos").build()
            );
            this.repositorioDeServicios.modificar(servicio2);
        }
    }
}
