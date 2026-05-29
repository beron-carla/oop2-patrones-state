package state.dos;

import static state.dos.Calculadora.VALOR_INICIAL;

public class EstadoError implements EstadoCalculadora {
    static final String MSG_ESTADO_ERROR = "La calculadora está en estado de error";
    private Calculadora calculadora;

    public EstadoError(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    @Override
    public String toString() {
        return "EstadoError";
    }

    @Override
    public void mas() {
        System.out.println(MSG_ESTADO_ERROR);
    }

    @Override
    public void borrar() {
        this.calculadora.estado = new EstadoInicial(this.calculadora);
        this.calculadora.valorAcumulado = VALOR_INICIAL;
    }

    @Override
    public void valor(double valor) {
        System.out.println(MSG_ESTADO_ERROR);
    }

    @Override
    public void mostrar() {
        System.out.println(MSG_ESTADO_ERROR);
    }

    @Override
    public void menos(double valor) {
        System.out.println(MSG_ESTADO_ERROR);
    }

    @Override
    public void dividido(double valor) {
        System.out.println(MSG_ESTADO_ERROR);
    }

    @Override
    public void por(double valor) {
        System.out.println(MSG_ESTADO_ERROR);
    }
}
