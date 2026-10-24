public class PricingCalculator {
    private DiscountStrategy strategy;

    public PricingCalculator(DiscountStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(DiscountStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException(
                    "Discount strategy cant be null"
            );
        }

        this.strategy = strategy;
    }

    public double calculateTotal(double unitPrice, int quantity) {
        if (unitPrice < 0) {
            throw new IllegalArgumentException(
                    "Unit price cant be negative"
            );
        }

        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "Quantity cant be negative"
            );
        }

        return strategy.calculateTotal(unitPrice, quantity);
    }
}