package models.repositories;

import domain.Colaborador;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

public class RepositorioDeColaboradores implements WithSimplePersistenceUnit {
    public void guardar(Colaborador colaborador) {
        entityManager().persist(colaborador);//INSERT
    }
}
