package climbStairs;

public class climbStairsDemo {
    public static void main(String[] args) {
        int n = 35;

        long sum = 0;
        for (int numberOfTwo = 0; numberOfTwo <= n / 2; numberOfTwo++) {
            int numberOfOne = n - numberOfTwo * 2;
            long number = getFactorial(numberOfOne + numberOfTwo) /
                    (getFactorial(numberOfOne) * getFactorial(numberOfTwo));
            sum += number;
        }

        System.out.println(sum);
    }

    public static long getFactorial(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }
}
