public class Number {

    public static double raiseToDegree(double number, double degree) {

        if (degree > 0) {
            return count(number, degree);
        } else {
            double degreeAbs = Math.abs(degree);
            return 1 / count(number, degreeAbs);
        }
    }

    private static double count(double number, double degree) {

        if (degree == 1) {
            return number;
        }

        return number * count(number, degree - 1);
    }
}
