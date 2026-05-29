package state.cuatro;

public class Cancelada extends EstadoCompra {
    OrdenDeCompra ordenDeCompra;

    public Cancelada(OrdenDeCompra ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }

    @Override
    public String toString() {
        return "Cancelada";
    }
}
