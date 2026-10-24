public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateTotal(double unitPrice, int quantity) {
        return unitPrice * quantity;
    }
}