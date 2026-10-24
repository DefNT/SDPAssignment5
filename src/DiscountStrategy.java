public interface DiscountStrategy {
    double calculateTotal(double unitPrice, int quantity);
}