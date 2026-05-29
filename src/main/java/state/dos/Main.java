package state.dos;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        System.out.println("Estado inicial: " + calculadora.estado());

        calculadora.valor(20);
        calculadora.por(2);
        System.out.println(calculadora.estado());
        calculadora.por(2);
        calculadora.mostrar();

//
//        calculadora.valor(10);
//
//        System.out.println("Estado después de ingresar operando: " + calculadora.estado());
//
//        calculadora.mas();
//        calculadora.mas();
//        calculadora.borrar();
//
//        System.out.println("Estado después de ingresar operando cero: " + calculadora.estado());
//
//        calculadora.valor(10);
//
//        calculadora.mostrar();
    }
}
