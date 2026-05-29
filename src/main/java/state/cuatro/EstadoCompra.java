package state.cuatro;

import static state.cuatro.OrdenDeCompra.*;

public abstract class EstadoCompra {
    public void agregarProducto(Producto producto) {
        throw new IllegalStateException(MSG_ERROR_AGREGAR_PRODUCTO);
    }

    public void confirmarCompra() {
        throw new IllegalStateException(MSG_ERROR_PREPARACION);
    }

    public void enviar() {
        throw new IllegalStateException(MSG_ERROR_ENVIAR);
    }

    public void cancelar() {
        throw new IllegalStateException(MSG_ERROR_CANCELAR);
    }
}
