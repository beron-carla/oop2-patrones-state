package state.dos;

import static state.dos.Calculadora.VALOR_INICIAL;

public class EstadoInicial implements EstadoCalculadora {
    private Calculadora calculadora;

    public EstadoInicial(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    @Override
    public String toString() {
        return "EstadoInicial";
    }

    @Override
    public void mas() {
        this.calculadora.estado = new EstadoEsperandoOperando(this.calculadora);
    }

    @Override
    public void borrar() {
        this.calculadora.valorAcumulado = VALOR_INICIAL;
    }

    @Override
    public void valor(double valor) {
        this.calculadora.valorAcumulado = valor;
    }

    @Override
    public void mostrar() {
        System.out.println(this.calculadora.valorAcumulado);

    }

    @Override
    public void menos(double valor) {
        this.calculadora.estado = new EstadoEsperandoOperando(this.calculadora);
    }

    @Override
    public void dividido(double valor) {
        this.calculadora.estado = new EstadoEsperandoOperando(this.calculadora);
    }

    @Override
    public void por(double valor) {
        this.calculadora.estado = new EstadoEsperandoOperando(this.calculadora);
    }
}
