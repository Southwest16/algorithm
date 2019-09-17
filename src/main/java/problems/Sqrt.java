package problems;

import java.text.DecimalFormat;

public class Sqrt {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.000000");
        System.out.println(df.format(getSqrt(15)));
    }

    public static double getSqrt(int value) {
        double start = 0.0;
        double end = value;
        double sqrt = 0.0;
        double epsil = 0.000001;

        while (start <= end) {
            double mid = start + (end - start) / 2;
            sqrt = mid;
            if (Math.abs(mid * mid - value) <= epsil) {
                return mid;
            } else if (mid * mid < value) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return sqrt;
    }
}
