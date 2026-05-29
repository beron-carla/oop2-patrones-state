package state.tres;

public class Euforica implements Estado {
    @Override
    public void realizarDeseo(Golondrina golondrina) {
        golondrina.volar();
    }
}
