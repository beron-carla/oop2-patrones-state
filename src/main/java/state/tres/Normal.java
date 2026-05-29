package state.tres;

public class Normal implements Estado {
    @Override
    public void realizarDeseo(Golondrina golondrina) {
        golondrina.volar();
    }
}
