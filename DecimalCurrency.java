/**
 * Represents a currency value in decimal (post-1971) British pennies.
 */
public class DecimalCurrency {
    private int pennies;

    /**
     * Constructs a DecimalCurrency object.
     * @param pennies the number of new (decimal) pennies
     */
    public DecimalCurrency(int pennies) {
        this.pennies = pennies;
    }

    /**
     * Converts this decimal currency to pre-decimal currency (pounds, shillings, pence).
     * @return PreDecimalCurrency equivalent
     */
    public PreDecimalCurrency toPreDecimal() {
        int pence = (int) Math.round(2.4 * pennies);

        int pounds = pence / 240; 
        int remainingPence = pence % 240; 

        int shillings = remainingPence / 12; 
        pence = remainingPence % 12; 
        return new PreDecimalCurrency(pounds, shillings, pence);
    }
}
