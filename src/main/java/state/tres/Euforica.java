package state.tres;

public class Euforica implements Estado {
    @Override
    public void realizarDeseo(Golondrina golondrina) {
        //golondrina eufórica - su deseo es volar 5  km y volver
        golondrina.volar();
    }
}
