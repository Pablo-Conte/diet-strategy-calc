package classes;

import types.BMRTypes;
import types.GenderTypes;

public class DietStrategyCalculator {
    private double weight;
    private double height;
    private int age;
    private double BMRValue;
    private GenderTypes gender;

    public DietStrategyCalculator(double weight, double height, int age, GenderTypes gender) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
    }

    public double getBMRValue() {
        return BMRValue;
    }

    public void setBMRValue(double BMR) {
        BMRValue = BMR;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void BMRCalculator(double exerciseCoeficient, BMRTypes type) {
        switch (type) {
            case HARRIS_BENEDICT:
                double result = BMR.harrisBenedict(this.weight, this.height, this.age, this.gender);
                this.setBMRValue(result);
                break;
            case OMS:
                result = BMR.OMS(this.weight, this.age, this.gender);
                this.setBMRValue(result);
                break;
            case MIFFLIN_ST_JEOR:
                result = BMR.mifflinStJeor(this.weight, this.height, this.age, this.gender);
                this.setBMRValue(result);
                break;
            default:
                break;
        }

        double BMRWithExercise = this.getBMRValue() * exerciseCoeficient;

        this.setBMRValue(BMRWithExercise);
    }

    public void CuttingMacros() {
        double protein = 2 * this.weight;
        double fat = 1 * this.weight;

        double proteinKcal = protein * 4;
        double fatKcal = fat * 9;

        double deficit = this.getBMRValue() * 0.15;
        double totalKcalToLoseWeight = this.getBMRValue() - deficit;

        double proteinKcalPlusFatKcal = proteinKcal + fatKcal;

        double carbsKcal = totalKcalToLoseWeight - proteinKcalPlusFatKcal;
        double carbs = carbsKcal / 4;

        System.out.println("=== Macronutrients for Cutting ===");
        System.out.printf("| %-10s | %7s | %10s |\n", "Macro", "Grams", "Calories");
        System.out.printf("|------------|---------|------------|\n");
        System.out.printf("| %-10s | %7.1f | %10.1f |\n", "Protein", protein, proteinKcal);
        System.out.printf("| %-10s | %7.1f | %10.1f |\n", "Fat", fat, fatKcal);
        System.out.printf("| %-10s | %7.1f | %10.1f |\n", "Carbs", carbs, carbsKcal);
        System.out.println("------------------------------------");
        System.out.printf("| %-19s | %10.1f |\n", "Total kcal to cut", totalKcalToLoseWeight);
        System.out.printf("| %-19s | %10.1f |\n", "Original TDEE", this.getBMRValue());
        System.out.printf("| %-19s | %10.1f |\n", "Caloric Deficit", deficit);
        System.out.println("====================================\n");
    }

    public void WaterIntakePerDay() {
        double waterIntake = this.weight * 0.033;

        System.out.println("=== Daily Water Intake ===");
        System.out.printf("| %-10s | %5.2f L |\n", "Water", waterIntake);
        System.out.println("===========================\n");
    }
}
