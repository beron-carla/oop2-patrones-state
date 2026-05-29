package state.dos;

import static state.dos.Calculadora.VALOR_INICIAL;

public class EstadoEsperandoOperando implements EstadoCalculadora {
    private Calculadora calculadora;

    public EstadoEsperandoOperando(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    @Override
    public String toString() {
        return "EstadoEsperandoOperando";
    }

    @Override
    public void mas() {
        this.calculadora.estado = new EstadoError(this.calculadora);
    }

    @Override
    public void borrar() {
        this.calculadora.estado = new EstadoInicial(this.calculadora);
        this.calculadora.valorAcumulado = VALOR_INICIAL;

    }

    @Override
    public void valor(double valor) {
        this.calculadora.valorAcumulado += valor;
        this.calculadora.estado = new EstadoInicial(this.calculadora);
    }

    @Override
    public void mostrar() {
        this.calculadora.estado = new EstadoError(this.calculadora);
    }

    @Override
    public void menos(double valor) {
        this.calculadora.valorAcumulado -= valor;
        this.calculadora.estado = new EstadoInicial(this.calculadora);
    }

    @Override
    public void dividido(double valor) {
        if (valor == 0) {
            this.calculadora.estado = new EstadoError(this.calculadora);
        } else {
            this.calculadora.valorAcumulado /= valor;
            this.calculadora.estado = new EstadoInicial(this.calculadora);
        }
    }

    @Override
    public void por(double valor) {
        this.calculadora.valorAcumulado *= valor;
        this.calculadora.estado = new EstadoInicial(this.calculadora);
    }
}
