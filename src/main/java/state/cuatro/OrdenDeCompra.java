package state.cuatro;

import java.util.ArrayList;
import java.util.List;

public class OrdenDeCompra {
    static final String MSG_ERROR_PREPARACION = "La orden solo puede pasar a preparacion desde iniciada";
    static final String MSG_ERROR_SIN_PRODUCTOS = "La orden debe tener al menos un producto";
    static final String MSG_ERROR_ENVIAR = "La orden solo puede enviarse desde en preparacion";
    static final String MSG_ERROR_CANCELAR = "La orden no puede cancelarse en este estado";
    static final String MSG_ERROR_AGREGAR_PRODUCTO = "No se pueden agregar productos en este estado";
    protected EstadoCompra estado;
    protected List<Producto> productos;
    protected double monto;
    protected String numeroSeguimiento;

    public OrdenDeCompra() {
        this.estado = new Iniciada(this);
        this.productos = new ArrayList<>();
        this.monto = 0;
        this.numeroSeguimiento = null;
    }

    public void agregarProducto(Producto producto) {
//        if (this.estado != Estado.INICIADA) {
//            throw new IllegalStateException(MSG_ERROR_AGREGAR_PRODUCTO);
//        }
//        this.productos.add(producto);
        estado.agregarProducto(producto);
    }

    public void confirmarCompra() {
//        if (this.estado != Estado.INICIADA) {
//            throw new IllegalStateException(MSG_ERROR_PREPARACION);
//        }
//        if (this.productos.isEmpty()) {
//            throw new IllegalStateException(MSG_ERROR_SIN_PRODUCTOS);
//        }

//        this.estado = Estado.EN_PREPARACION;
//        this.monto = calcularMonto();
        estado.confirmarCompra();
    }

    public void enviar() {
//        if (this.estado != Estado.EN_PREPARACION) {
//            throw new IllegalStateException(MSG_ERROR_ENVIAR);
//        }
//        this.estado = Estado.ENVIADA;
//        this.numeroSeguimiento = generarNumeroSeguimiento();
        estado.enviar();
    }

    public void cancelar() {
//        if (this.estado != Estado.INICIADA && this.estado != Estado.EN_PREPARACION) {
//            throw new IllegalStateException(MSG_ERROR_CANCELAR);
//        }
//        this.estado = Estado.CANCELADA;
        estado.cancelar();
    }

    public EstadoCompra estado() {
        return this.estado;
    }

    public double monto() {
        return this.monto;
    }

//    public String numeroSeguimiento() {
//        return this.numeroSeguimiento;
//    }
//
//    public List<Producto> productos() {
//        return new ArrayList<>(this.productos);
//    }

    protected double calcularMonto() {
        return this.productos.stream().mapToDouble(Producto::precio).sum();
    }

    protected String generarNumeroSeguimiento() {
        return "SEG-" + System.currentTimeMillis();
    }

}
