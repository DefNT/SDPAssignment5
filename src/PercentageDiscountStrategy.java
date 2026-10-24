public class PercentageDiscountStrategy implements DiscountStrategy {
    private final double percent;

    public PercentageDiscountStrategy(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException(
                    "Percentage must be between 0 and 100"
            );
        }

        this.percent = percent;
    }

    @Override
    public double calculateTotal(double unitPrice, int quantity) {
        double fullPrice = unitPrice * quantity;
        double discount = fullPrice * percent / 100;

        return fullPrice - discount;
    }
}