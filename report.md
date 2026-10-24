# Assignment 4 Strategy Pattern 

Github: https://github.com/DefNT/SDPAssignment5.git

## Introduction
The purpose of this project is to implement the Strategy design pattern. The topic is a Discount and Pricing Calculator that calculates the total price of products using different discount strategies
In a shopping system, different customers or promotions may use different pricing rules. For example, a customer may receive no discount, a percentage discount, a fixed-amount discount, or a Buy One Get One Free offer
The project contains four concrete strategies:
•	NoDiscountStrategy: calculates the total price without applying a discount
•	PercentageDiscountStrategy: reduces the total price by a specified percentage
•	FixedAmountDiscountStrategy: subtracts a fixed amount from the total price, without allowing the final price to become negative
•	BuyOneGetOneFreeStrategy: charges for every other item, rounding up when the quantity is odd
All strategies implement the same DiscountStrategy interface, which declares the calculateTotal() method
The PricingCalculator class acts as the Context. It stores the selected strategy and delegates the calculation to it. The Main class acts as the Client and demonstrates changing strategies at runtime

## UML diagram

<img width="1276" height="433" alt="image" src="https://github.com/user-attachments/assets/7d2c3b66-98ff-46d1-8282-1c9d44eb4d63" />

## Clean Code Principles

### 1. Meaningful names

<img width="662" height="249" alt="image" src="https://github.com/user-attachments/assets/00e10126-6520-498c-8d0e-d212946bb273" />

The names calculateTotal, unitPrice, and quantity make the method easier to understand. Strategy class names also reveal which pricing algorithm each class implements

### 2. Single Responsibility Principle

<img width="667" height="497" alt="image" src="https://github.com/user-attachments/assets/d6a8fca2-f57a-43e3-ab8c-3106fb7f5959" />

The percentage strategy contains the percentage calculation, while the other strategies implement their own algorithms. This makes each class easier to read

### 3. Replacing Conditionals with Polymorphism

<img width="668" height="431" alt="image" src="https://github.com/user-attachments/assets/032288ec-b456-476f-8e85-8d692504aae3" />


The Context calls the same method regardless of which strategy is selected. The actual calculation is performed by the concrete strategy. The if statements used for input validation in PricingCalculator do not select between discount algorithms

### 4. Dependency Inversion Principle

<img width="673" height="521" alt="image" src="https://github.com/user-attachments/assets/8231ce9d-f929-4f2b-a654-e65a0c52fd1f" />

The Context can now store any implementation of the DiscountStrategy interface. This reduces coupling between the Context and the concrete strategies

### 5. Open/Closed Principle

Example:
```
public class SeasonalDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculateTotal(double unitPrice, int quantity) {
        double fullPrice = unitPrice * quantity;
        return fullPrice * 0.90;
    }
}
```
A new strategy can implement the interface and then be supplied to the existing Context. PricingCalculator does not need to be modified. The example above shows a possible extension

### 6. Input Validation 

<img width="673" height="458" alt="image" src="https://github.com/user-attachments/assets/993f03eb-9b14-4819-87b0-f2f606cb32dd" />

These checks make the program more reliable and give clear feedback when invalid values are passed

## Strategy Pattern/State Pattern
The Strategy pattern is appropriate for this project because the client chooses between different pricing algorithms. Each strategy represents an alternative way to calculate the total price. The selected strategy can be changed at runtime without changing the Context
The State pattern also delegates behavior to separate classes, but its purpose is different. It represents an object's internal state and allows its behavior to change as that state changes, often through state transitions. In this project, the pricing calculator does not have states such as waiting, processing, or completed. Instead, the client selects a pricing algorithm, so Strategy is the better fit

## Conclusion
This project demonstrates how the Strategy pattern can make a pricing calculator more flexible and maintainable. Each discount algorithm is implemented in a separate class that follows the same interface. The PricingCalculator does not need to know how each algorithm works, it only delegates the calculation to the selected strategy
The main advantage is extensibility. A new discount algorithm can be added by implementing DiscountStrategy, without modifying the existing Context. Runtime switching also allows the same calculator object to use different pricing rules
The main trade-off is that the design introduces additional classes compared with placing all formulas in one class. For this project, the additional classes are justified because they separate responsibilities and make the algorithms easier to understand,test and extend

