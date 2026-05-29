package state.cuatro;

public class EnPreparacion extends EstadoCompra {
    OrdenDeCompra ordenDeCompra;

    public EnPreparacion(OrdenDeCompra ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }
    //hereda el agregar producto de EstadoCompra, todas se comportan igual, menos iniciada


    @Override
    public void enviar() {
        this.ordenDeCompra.estado = new Enviada(this.ordenDeCompra);
        this.ordenDeCompra.numeroSeguimiento = ordenDeCompra.generarNumeroSeguimiento();
    }

    @Override
    public void cancelar() {
        this.ordenDeCompra.estado = new Cancelada(this.ordenDeCompra);
    }
}
