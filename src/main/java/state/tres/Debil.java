package state.tres;

public class Debil implements Estado {
    @Override
    public void realizarDeseo(Golondrina golondrina) {
        // golondrina debil - su deseo es comer, 50 gr es suficiente
        golondrina.comer();
    }
}
