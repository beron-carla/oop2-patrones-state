package state.uno;

public class EstadoCerrada implements EstadoPuerta {
    private Puerta puerta;

    public EstadoCerrada(Puerta puerta) {
        this.puerta = puerta;
    }

    @Override
    public void abrir() {
        System.out.print("Abriendo la puerta...");
        this.puerta.estadoPuerta = new EstadoAbierta(this.puerta);
    }

    @Override
    public void cerrar() {
        System.out.println("no se puede cerrar una puerta cerrada");

    }

    @Override
    public String toString() {
        return "Cerrada";
    }
}
