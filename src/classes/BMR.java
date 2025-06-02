package classes;

import types.GenderTypes;

public class BMR {
    public static double harrisBenedict(double weight, double height, int age, GenderTypes gender) {
        if (gender == GenderTypes.Male) {
            return 66.5 + (13.75 * weight) + (5.0 * height) - (6.75 * age);
        }

        return 655 + (9.6 * weight) + (1.9 * height) - (4.7 * age);
    }

    public static double OMS(double weight, int age, GenderTypes gender) {
        if (gender == GenderTypes.Male) {
            if (age >= 10 && age < 18) {
                return (17.686 * weight) + 658.2;
            } else if (age >= 18 && age < 30) {
                return (15.057 * weight) + 692.2;
            } else if (age >= 30 && age <= 60) {
                return (11.472 * weight) + 873.1;
            } else if (age > 60) {
                return (11.711 * weight) + 587.7;
            }

            throw new IllegalArgumentException("Invalid age for OMS calculation: " + age);
        }

        if (age >= 10 && age < 18) {
            return (13.384 * weight) + 692.2;
        } else if (age >= 18 && age < 30) {
            return (14.818 * weight) + 486.6;
        } else if (age >= 30 && age <= 60) {
            return (8.126 * weight) + 845.6;
        } else if (age > 60) {
            return (9.082 * weight) + 658.5;
        }

        throw new IllegalArgumentException("Invalid age for OMS calculation: " + age);
    }

    public static double mifflinStJeor(double weight, double height, int age, GenderTypes gender) {
        if (gender == GenderTypes.Male) {
            return (10 * weight) + (6.25 * height) - (5.0 * age) + 5;
        }

        return (10 * weight) + (6.25 * height) - (5.0 * age) - 161;
    }
}
