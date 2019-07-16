package learn;

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

        int sum = 0;
        while (start <= end) {
            double mid = (start + end) / 2;
            sqrt = mid;
            System.out.println(sum);
            if (Math.abs(mid * mid - value) <= epsil) {
                return mid;
            } else if (mid * mid < value) {
                start = mid;
            } else {
                end = mid;
            }
            sum += 1;
        }

        return sqrt;
    }
}
