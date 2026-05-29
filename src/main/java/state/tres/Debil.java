package state.tres;

public class Debil implements Estado {
    @Override
    public void realizarDeseo(Golondrina golondrina) {
        golondrina.comer();
    }
}
