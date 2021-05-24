package June2020.reverse7;

public class reverseDemo {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();
        System.out.println(reverse2(-1234567));
        long endTome = System.currentTimeMillis();
        System.out.println((endTome-starTime)+"ms");
    }

    public static int reverse(int x) {
        if (x > 0) {
            String s = String.valueOf(x);
            String ss = new StringBuilder(s).reverse().toString();
            long i = Long.parseLong(ss);
            if (i > 2147483647L) {
                return 0;
            }
            return (int) i;
        }

        if (x < 0 && x > -2147483648) {
            String s = String.valueOf(-x);
            String ss = new StringBuilder(s).reverse().toString();
            long i = Long.parseLong(ss);
            if (i > 2147483648L) {
                return 0;
            }
            return -(int) i;
        }

        return 0;
    }

    public static  int reverse2(int x) {
        long temp = 0;

        while(x != 0){
            int pop = x % 10;
            temp = temp * 10 + pop;

            if(temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE){
                return 0;
            }
            x /= 10;
        }
        return (int)temp;
    }
}
