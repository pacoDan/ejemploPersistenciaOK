package models.repositories;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

public class Repositorio implements WithSimplePersistenceUnit {

    public void guardar(Object o) {
        entityManager().persist(o);
    }
}
