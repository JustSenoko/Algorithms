package lesson5;

class Degree {

    static double degree(double x, int degree) {
        if (x == 1) {
            return 1;
        }
        if (degree == 0) {
            return 1;
        } else if (degree > 0) {
            return degree(x, --degree) * x;
        } else {
            return degree(x, ++degree) / x;
        }
    }
}
