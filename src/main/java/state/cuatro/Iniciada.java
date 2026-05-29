package state.cuatro;

import static state.cuatro.OrdenDeCompra.MSG_ERROR_SIN_PRODUCTOS;

public class Iniciada extends EstadoCompra {
    OrdenDeCompra ordenDeCompra;

    public Iniciada(OrdenDeCompra ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }

    @Override
    public void agregarProducto(Producto producto) {
        this.ordenDeCompra.productos.add(producto);
    }

    @Override
    public void confirmarCompra() {
        if (ordenDeCompra.productos.isEmpty()) {
            throw new IllegalStateException(MSG_ERROR_SIN_PRODUCTOS);
        }
        this.ordenDeCompra.estado = new EnPreparacion(this.ordenDeCompra);
        this.ordenDeCompra.monto = ordenDeCompra.calcularMonto();
    }


    @Override
    public void cancelar() {
        this.ordenDeCompra.estado = new Cancelada(this.ordenDeCompra);
    }
}
