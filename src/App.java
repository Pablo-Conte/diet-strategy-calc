import java.util.Scanner;

import classes.DietStrategyCalculator;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Diet Strategy Calc!");

        System.out.print("Enter your weight in kg: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height in cm: ");
        double height = scanner.nextDouble();

        System.out.print("Enter your age in years: ");
        int age = scanner.nextInt();

        System.out.print("Enter your exercise coefficient (1.2, 1.375, 1.55, 1.725, 1.9): ");
        double exerciseCoefficient = scanner.nextDouble();

        DietStrategyCalculator calculator = new DietStrategyCalculator(weight, height, age);

        System.out.println("----- My informations: -----");
        System.out.println("Age: " + calculator.getAge() + " years");
        System.out.println("Height: " + calculator.getHeight() + " cm");
        System.out.println("Weight: " + calculator.getWeight() + " kg\n");
        System.out.println("----- My fitness Info: -----");
        calculator.BMRCalculator(exerciseCoefficient);
        System.out.println("----- My diet strategy: -----");
        System.out.println("Cutting macros:");
        calculator.CuttingMacros();
        System.out.println("------------------------------------");

        scanner.close();
    }
}
