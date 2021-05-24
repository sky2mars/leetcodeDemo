package isHappy;

public class isHappyDemo2 {
    public static void main(String[] args) {
        boolean b = isHappy(20);
        System.out.println(b);
    }

    //快慢法：
    public static boolean isHappy(int n) {
        int fast = n;//19
        int slow = n;//19
        do {
            slow = squareSum(slow);//82
            fast = squareSum(fast);//n82
            fast = squareSum(fast);//68
        } while (slow != fast);//只要不等，就一直循环
        //所有不快乐数的数位平方和计算，最後都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中。
        //如果不是快乐数，是死循环，由于快的多执行两次，慢的执行一次，所以必然某次相等，跳出循环
        //如果是快乐数，最终会变成1，最终跳出循环
        if (fast == 1)
            return true;
        else return false;
    }

    private static int squareSum(int m) {//这个方法用于取平方和
        int squaresum = 0;//定义平方和
        while (m != 0) {//m=128
            squaresum += (m % 10) * (m % 10);//sum=8*8+2*2+1*1
            m /= 10;//m=12
        }
        return squaresum;
    }

}