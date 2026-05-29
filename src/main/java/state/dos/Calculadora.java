package state.dos;

public class Calculadora {
    static final double VALOR_INICIAL = 0.0;
    static final String MSG_ESTADO_ERROR = "La calculadora está en estado de error";
    public EstadoCalculadora estado;
    double valorAcumulado;

    public Calculadora() {
        this.estado = new EstadoInicial(this);
        this.valorAcumulado = VALOR_INICIAL;
    }

    String estado() {
        return this.estado.toString();
    }


    public void mas() {
        this.estado.mas();
    }

    public void borrar() {
        this.estado = new EstadoInicial(this);
        this.valorAcumulado = VALOR_INICIAL;
    }

    public void valor(double valor) {
        estado.valor(valor);
    }

    public void mostrar() {
        this.estado.mostrar();
    }

    public void menos(double valor) {
        this.estado.menos(valor);
    }

    public void dividido(double valor) {
        this.estado.dividido(valor);
    }

    public void por(double valor) {
        this.estado.por(valor);
    }
}
