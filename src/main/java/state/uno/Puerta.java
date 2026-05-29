package state.uno;

public class Puerta {

    EstadoPuerta estadoPuerta;

    public Puerta() {
        this.estadoPuerta = new EstadoCerrada(this);
    }

    public String estado() {
        return estadoPuerta.toString();
    }

    public void abrir() {
        this.estadoPuerta.abrir();
    }

    public void cerrar() {
        this.estadoPuerta.cerrar();
        this.estadoPuerta = new EstadoCerrada(this);
    }
}
