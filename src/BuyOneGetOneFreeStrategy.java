public class BuyOneGetOneFreeStrategy implements DiscountStrategy {

    @Override
    public double calculateTotal(double unitPrice, int quantity) {
        int itemsToPayFor = quantity / 2 + quantity % 2;

        return unitPrice * itemsToPayFor;
    }
}