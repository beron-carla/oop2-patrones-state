package state.uno;

public class EstadoAbierta implements EstadoPuerta {
    private Puerta puerta;

    public EstadoAbierta(Puerta puerta) {
        this.puerta = puerta;
    }

    @Override
    public void abrir() {
        System.out.println("NO se puede abrir una puerta abierta");

    }

    @Override
    public void cerrar() {
        System.out.println("Cerrando la puerta...");
        this.puerta.estadoPuerta = new EstadoCerrada(this.puerta);
    }

    @Override
    public String toString() {
        return "Abierta";
    }
}
