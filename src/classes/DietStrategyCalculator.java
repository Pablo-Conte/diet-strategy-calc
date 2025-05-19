package classes;

public class DietStrategyCalculator {
    private double weight;
    private double height;
    private int age;

    public DietStrategyCalculator(double weight, double height, int age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
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
        double BMRWithExercise = exerciseCoeficient
                * (66.47 + (13.75 * this.weight) + (5 * this.height) - (6.8 * this.age));

        System.out.println("Harris-Benedict: " + HarrisBenedict);
        System.out.println("OMS: " + OMS);
        System.out.println("Mifflin-St Jeor: " + MifflinStJeor + " (acurate for lost weight)");
        System.out.println("BMR with exercise: " + BMRWithExercise);
    }

    public void CuttingMacros() {
        double protein = 2 * this.weight;
        double fat = 1 * this.weight;
        double carbs = 2 * this.weight;

        System.out.println("Protein (2g/kg): " + protein + "g");
        System.out.println("Fat (1g/kg): " + fat + "g");
        System.out.println("Carbs (2g/kg): " + carbs
                + "g (if you are not losting weight, you can decrease it to 0.2g and see the results)");
    }
}
