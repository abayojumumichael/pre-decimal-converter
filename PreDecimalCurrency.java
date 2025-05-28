/**
 * Represents a currency value in pre-decimal British format (pounds, shillings, pence).
 */
public class PreDecimalCurrency {
    private int pounds;
    private int shillings;
    private int pence;

    /**
     * Constructs a PreDecimalCurrency object.
     * @param pounds the number of pounds
     * @param shillings the number of shillings
     * @param pence the number of pence
     */
    public PreDecimalCurrency(int pounds, int shillings, int pence) {
        this.pounds = pounds;
        this.shillings = shillings;
        this.pence = pence;
    }

    /**
     * Returns a string representation in the format £x ys zd.
     * @return formatted string
     */
    @Override
    public String toString() {
        return String.format("£%d %ds %dd", pounds, shillings, pence);
    }
}