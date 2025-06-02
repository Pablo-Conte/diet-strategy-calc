import java.util.Scanner;

import classes.DietStrategyCalculator;
import types.GenderTypes;

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

        System.out.println("Genders: ");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.print("Select your gender (1 or 2): ");
        int genderChoice = scanner.nextInt();

        GenderTypes gender;

        switch (genderChoice) {
            case 1:
                gender = GenderTypes.Male;
                break;
            case 2:
                gender = GenderTypes.Female;
                break;
            default:
                scanner.close();
                throw new IllegalArgumentException("Invalid number!");

        }

        System.out.println("Formula types: ");
        System.out.println("1. Harris-Benedict");
        System.out.println("2. OMS");
        System.out.println("3. Mifflin-St Jeor");
        System.out.print("Select the formula type (1, 2, or 3): ");
        int formulaChoice = scanner.nextInt();

        types.BMRTypes formulaType;

        switch (formulaChoice) {
            case 1:
                formulaType = types.BMRTypes.HARRIS_BENEDICT;
                break;
            case 2:
                formulaType = types.BMRTypes.OMS;
                break;
            case 3:
                formulaType = types.BMRTypes.MIFFLIN_ST_JEOR;
                break;
            default:
                scanner.close();
                throw new IllegalArgumentException("Invalid number!");
        }

        DietStrategyCalculator calculator = new DietStrategyCalculator(weight, height, age, gender);

        System.out.println("----- My informations: -----");
        System.out.println("Age: " + calculator.getAge() + " years");
        System.out.println("Height: " + calculator.getHeight() + " cm");
        System.out.println("Weight: " + calculator.getWeight() + " kg\n");

        calculator.BMRCalculator(exerciseCoefficient, formulaType);
        calculator.CuttingMacros();
        calculator.WaterIntakePerDay();

        scanner.close();
    }
}
