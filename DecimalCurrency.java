public class DecimalCurrency {
    private int pennies;

    public DecimalCurrency(int pennies) {
        this.pennies = pennies;
    }

    public PreDecimalCurrency toPreDecimal() {
        int pence = (int) Math.round(2.4 * pennies);

        int pounds = pence / 240; 
        int remainingPence = pence % 240; 

        int shillings = remainingPence / 12; 
        pence = remainingPence % 12; 
        return new PreDecimalCurrency(pounds, shillings, pence);
    }
}
