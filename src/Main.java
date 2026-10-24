public class Main {
    public static void main(String[] args) {
        double unitPrice = 10000.0;
        int quantity = 2;

        PricingCalculator calculator = new PricingCalculator(
                new NoDiscountStrategy()
        );

        printResult("No discount", calculator, unitPrice, quantity);

        calculator.setStrategy(new PercentageDiscountStrategy(20));
        printResult("Percentage discount (20%)", calculator, unitPrice, quantity);

        calculator.setStrategy(new FixedAmountDiscountStrategy(750));
        printResult("Fixed discount (750 KZT)", calculator, unitPrice, quantity);

        calculator.setStrategy(new BuyOneGetOneFreeStrategy());
        printResult("Buy one get one free", calculator, unitPrice, quantity);
    }

    private static void printResult(String name, PricingCalculator calculator,
                                    double unitPrice, int quantity) {
        double originalPrice = unitPrice * quantity;
        double finalPrice = calculator.calculateTotal(unitPrice, quantity);
        double discount = originalPrice - finalPrice;

        System.out.printf("%-30s original = %.2f KZT, discount = %.2f KZT, final = %.2f KZT%n",
                name + ":", originalPrice, discount, finalPrice);
    }
}