package models.repositories;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import models.entities.servicios.Servicio;

import java.util.List;
import java.util.Optional;

public class RepositorioDeServicios implements WithSimplePersistenceUnit {

    public void guardar(Servicio servicio) {
        entityManager().persist(servicio);//INSERT
    }

    public void modificar(Servicio servicio) {
        withTransaction(() -> {
            entityManager().merge(servicio);//UPDATE
        });
    }

    public void eliminarFisico(Servicio servicio) {
        entityManager().remove(servicio);//DELETE
    }

    public void eliminar(Servicio servicio) {
        servicio.setActivo(false);
        entityManager().merge(servicio);
    }

    public Optional<Servicio> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager().find(Servicio.class, id));
    }

    public Servicio buscarPorId2(Long id) {
        return entityManager().find(Servicio.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Servicio> buscarPorNombre(String nombre) {
        return entityManager()
                .createQuery("from " + Servicio.class.getName() + " where nombre =:name")
                .setParameter("name", nombre)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Servicio> buscarTodos() {
        return entityManager()
                .createQuery("from " + Servicio.class.getName())
                .getResultList();
    }
}
