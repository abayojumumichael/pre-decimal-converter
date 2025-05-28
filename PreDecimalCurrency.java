public class PreDecimalCurrency {
    private int pounds;
    private int shillings;
    private int pence;

    public PreDecimalCurrency(int pounds, int shillings, int pence) {
        this.pounds = pounds;
        this.shillings = shillings;
        this.pence = pence;
    }

    public int getPounds() {
        return pounds;
    }

    public int getShillings() {
        return shillings;
    }

    public int getPence() {
        return pence;
    }

    @Override
    public String toString() {
        return String.format("£%d %ds %dd", pounds, shillings, pence);
    }
}