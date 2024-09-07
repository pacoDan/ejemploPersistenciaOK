package domain.canjes;

import java.util.List;

public class EmpresaColaboradora {
    private List<Canjeable> canjeablesOfrecidos;

    public Canjeable ofrecerServicio() {
        return new ServicioCanjeable("servicio de 30 megas gratis");
    }
    public Canjeable ofrecerProducto() {
        return new ProductoCanjeable("heladera de 400 frigorias");
    }
}
