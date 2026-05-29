package state.cuatro;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestOrdenDeCompra {
    @DisplayName("Crea una orden de compra")
    @Test
    void testOrdenDeCompra() {
        var producto = new Producto("laptop", 100);
        var ordenDeCompra = new OrdenDeCompra();
        ordenDeCompra.agregarProducto(producto);
        ordenDeCompra.confirmarCompra();
        ordenDeCompra.enviar();
        assertEquals(100, ordenDeCompra.monto());
        assertEquals("Enviada", ordenDeCompra.estado().toString());
    }

    @DisplayName("Test agregar un producto en una orden enviada")
    @Test
    void testAgregarProductoEstadoEnviado() {
        var producto = new Producto("laptop", 200);
        var ordenDeCompra = new OrdenDeCompra();
        ordenDeCompra.agregarProducto(producto);
        ordenDeCompra.confirmarCompra();
        ordenDeCompra.enviar();

        var e = assertThrows(RuntimeException.class, () -> {
            ordenDeCompra.agregarProducto(new Producto("laptopMac", 1000));

        });
        assertEquals(OrdenDeCompra.MSG_ERROR_AGREGAR_PRODUCTO, e.getMessage());


    }

    @DisplayName("Test confirmar una orden ya confirmada")
    @Test
    void testConfirmarOrden() {
        var ordenDeCompra = new OrdenDeCompra();
        ordenDeCompra.agregarProducto(new Producto("laptopAcer", 500));
        ordenDeCompra.confirmarCompra();
        var e = assertThrows(RuntimeException.class, () -> {
            ordenDeCompra.confirmarCompra();
        });
        assertEquals(OrdenDeCompra.MSG_ERROR_PREPARACION, e.getMessage());

    }

    @DisplayName("Test confirmar una orden sin productos")
    @Test
    void testConfirmaOrdenSinProductos() {
        var ordenDeCompra = new OrdenDeCompra();

        var e = assertThrows(RuntimeException.class, () -> {
            ordenDeCompra.confirmarCompra();
        });

        assertEquals(OrdenDeCompra.MSG_ERROR_SIN_PRODUCTOS, e.getMessage());
    }

    @DisplayName("Test enviar una orden sin confirmar")
    @Test
    void testEnviarSinConfirmar() {
        var ordenDeCompra = new OrdenDeCompra();
        ordenDeCompra.agregarProducto(new Producto("laptopMac", 1000));
        var e = assertThrows(RuntimeException.class, () -> {
            ordenDeCompra.enviar();
        });
        assertEquals(OrdenDeCompra.MSG_ERROR_ENVIAR, e.getMessage());
    }

    @DisplayName("Test cancelar una orden enviada")
    @Test
    void testCancelarOrdenEnviada() {
        var ordenDeCompra = new OrdenDeCompra();
        ordenDeCompra.agregarProducto(new Producto("laptopMac", 1000));
        ordenDeCompra.confirmarCompra();
        ordenDeCompra.enviar();
        var e = assertThrows(IllegalStateException.class, () -> {
            ordenDeCompra.cancelar();
        });
        assertEquals(OrdenDeCompra.MSG_ERROR_CANCELAR, e.getMessage());
    }

    @DisplayName("Test cancelar una orden dos veces")
    @Test
    void testCancelarOrdenCancelada() {
        var ordenDeCompra = new OrdenDeCompra();
        ordenDeCompra.agregarProducto(new Producto("laptopMac", 1000));
        ordenDeCompra.confirmarCompra();
        ordenDeCompra.cancelar();
        var e = assertThrows(IllegalStateException.class, () -> {
            ordenDeCompra.cancelar();
        });
        assertEquals(OrdenDeCompra.MSG_ERROR_CANCELAR, e.getMessage());
    }

    @DisplayName("Test cancelar una orden iniciada")
    @Test
    void testCancelarOrdenIniciada() {
        var ordenDeCompra = new OrdenDeCompra();
        ordenDeCompra.cancelar();
        assertEquals("Cancelada", ordenDeCompra.estado().toString());
    }
}
