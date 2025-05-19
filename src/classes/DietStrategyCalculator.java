package classes;

public class DietStrategyCalculator {
    private double weight;
    private double height;
    private int age;
    private double BMR;

    public DietStrategyCalculator(double weight, double height, int age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public double getBMR() {
        return BMR;
    }

    public void setBMR(double bMR) {
        BMR = bMR;
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

    public void BMRCalculator(double exerciseCoeficient) {
        double HarrisBenedict = 66 + (13.8 * this.weight) + (5.0 * this.height) - (6.8 * this.age);
        double OMS = (15.057 * this.weight) + 692.2;
        double MifflinStJeor = (10 * this.weight) + (6.25 * this.height) - (5.0 * this.age) - 161;

        double BMR = (13.75 * this.weight) + (5 * this.height) - (6.75 * this.age) + 66.5;
        double BMRWithExercise = BMR * exerciseCoeficient;

        System.out.println("\n=== BMR Calculation Table ================");
        System.out.printf("| %-20s | %10.2f kcal |\n", "Harris-Benedict", HarrisBenedict);
        System.out.printf("| %-20s | %10.2f kcal |\n", "FAO/OMS", OMS);
        System.out.printf("| %-20s | %10.2f kcal |\n", "Mifflin-St Jeor", MifflinStJeor);
        System.out.printf("| %-20s | %10.2f kcal |\n", "BMR w/ Exercise", BMRWithExercise);
        System.out.println("==========================================\n");

        this.setBMR(BMRWithExercise);
    }

    public void CuttingMacros() {
        double protein = 2 * this.weight;
        double fat = 1 * this.weight;

        double proteinKcal = protein * 4;
        double fatKcal = fat * 9;

        double deficit = this.getBMR() * 0.15;
        double totalKcalToLoseWeight = this.getBMR() - deficit;

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
        System.out.printf("| %-19s | %10.1f |\n", "Original TDEE", this.getBMR());
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
