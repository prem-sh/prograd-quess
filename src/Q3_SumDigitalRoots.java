public class Q3_SumDigitalRoots {
    public static int digital_root(int n) {
        int sum = 0;
        while (true) {
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            if (sum > 9) {
                n = sum;
                sum = 0;
            } else {
                return sum;
            }
        }
    }
}
