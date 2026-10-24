public class FixedAmountDiscountStrategy implements DiscountStrategy {
    private final double amount;

    public FixedAmountDiscountStrategy(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Discount amount cant be negative"
            );
        }

        this.amount = amount;
    }

    @Override
    public double calculateTotal(double unitPrice, int quantity) {
        double fullPrice = unitPrice * quantity;
        double discount = Math.min(amount, fullPrice);

        return fullPrice - discount;
    }
}