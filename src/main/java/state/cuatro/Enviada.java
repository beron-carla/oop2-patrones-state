package state.cuatro;

public class Enviada extends EstadoCompra {
    OrdenDeCompra ordenDeCompra;

    public Enviada(OrdenDeCompra ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }


    @Override
    public String toString() {
        return "Enviada";
    }
}
