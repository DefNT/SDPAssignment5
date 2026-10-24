# Discount and Pricing Calculator

## Overview

This project demonstrates the Strategy design pattern using a simple discount and pricing calculator

The program calculates the final price of products using interchangeable pricing algorithms. The client can change the selected strategy at runtime without modifying the calculator itself

## Project Structure
```
src/
  ├── BuyOneGetOneFreeStrategy.java
  ├── DiscountStrategy.java
  ├── FixedAmountDiscountStrategy.java
  ├── Main.java
  ├── NoDiscountStrategy.java
  ├── PercentageDiscountStrategy.java
  └── PricingCalculator.java
```

## Implemented Strategies

| Strategy | Description |
|---|---|
| `NoDiscountStrategy` | Returns the original total without a discount |
| `PercentageDiscountStrategy` | Subtracts a percentage of the original total |
| `FixedAmountDiscountStrategy` | Subtracts a fixed amount without allowing a negative final price |
| `BuyOneGetOneFreeStrategy` | Charges for every other item, rounding up for an odd quantity |

All four classes implement the `DiscountStrategy` interface and provide the `calculateTotal()` method

## How to Run

### Requirements

Install JDK 17 or a newer compatible JDK

### Using IntelliJ IDEA or any IDE

1. Open the project folder
2. Make sure the project SDK is set to Java 17 or newer
3. Open `src/Main.java`
4. Run the `main()` method

## Adding a New Strategy

The project can be extended without modifying `PricingCalculator`

To add a new discount strategy:

1. Create a new class in the `src` package
2. Implement `DiscountStrategy`
3. Provide an implementation of `calculateTotal(double unitPrice, int quantity)`
4. Select the new strategy in the client using `setStrategy()`

For example, a new strategy could implement a seasonal discount:

```java
package pricing;

public class SeasonalDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateTotal(double unitPrice, int quantity) {
        double fullPrice = unitPrice * quantity;
        return fullPrice * 0.90;
    }
}
```

The client can select it with:

```java
calculator.setStrategy(new SeasonalDiscountStrategy());
```
