package state.tres;

public class Golondrina {
    public static final int JOULES_ESFUERZO_INICIAL = 10;
    public static final int COEFICIENTE = 5;
    private int energia; //joules

    public Golondrina() {
        this.energia = 45;
    }

    public void comer() {
        //implementar
        //Cuando come, recupera 5 joules por cada gramo que come
        // golondrina debil - su deseo es comer, 50 gr es suficiente
        this.energia += (COEFICIENTE * 50);
    }

    public void volar() {
        //implementar
        //golondrina eufórica - su deseo es volar 5  km y volver
        //Cuando vuela, consume
        //un joule por cada kilómetro volado, más 10 joules fijos en cada vuelo debido al esfuerzo por
        //comenzar a volar.
        this.energia -= (5 * 2) + JOULES_ESFUERZO_INICIAL;
    }

    private Estado obtenerEstado() {
        if (golondrinaDebil()) return new Debil();
        if (golondrinaEuforica()) return new Euforica();
        return new Normal();
    }

    public void realizarDeseo() {
        obtenerEstado().realizarDeseo(this);
//        //debil
//        if (golondrinaDebil()) {
//            comer();
//        }
//        //euforica
//        if (golondrinaEuforica()) {
//            volar();
//        }

    }

    private boolean golondrinaEuforica() {
        return this.energia > 500;
    }

    private boolean golondrinaDebil() {
        return (this.energia < 50);
    }
    //Toda golondrina es capaz de volar y comer y posee una energía medida en joules, la cual va
    //variando a medida que come o vuela. Al nacer, su energía es de 45 Joules. Cuando vuela, consume
    //un joule por cada kilómetro volado, más 10 joules fijos en cada vuelo debido al esfuerzo por
    //comenzar a volar. Cuando come, recupera 5 joules por cada gramo que come
    //A las golondrinas les gusta realizar su deseo. Cuando se sienten eufóricas, su deseo es volar 5
    //kilómetros, como un paseo, y volver a su lugar de origen. Cuando se sienten débiles, su deseo es
    //comer (con 50 gramos de comida es suficiente) para recuperar energía y estar en condiciones de
    //volar cada vez que sea necesario. A medida que vuelan, las golondrinas consumen energía y se van cansando.
    // Digamos que se sienten débiles cuando su energía está por debajo de los 50 joules.
    // Cuando superan los 500 joules, se ponen eufóricas.
    //Implementar utilizando el patrón State y realice un diagrama de clases. En este caso particular,
    // la implementación será sin persistir el estado (como se sienten las golondrinas) es decir,
    // no habrá una variable de instancia estadoGolondrina.
    // La única variable de instancia será su energía
    // y el estado o como se siente la golondrina se calculará en función de su energía.
    // En el repo ya existe parte de la implementación.


}
