package isHappy;

public class isHappyDemo {
    public static void main(String[] args) {
        boolean b = isHappy(19);
        System.out.println(b);
    }

    public static boolean isHappy(int n) {
        //难点1：确定n的位数
        //难点2：对无限循环的判断
        //用if范围判断  X

        //如果次数超过100次，视为无限循环
        int count = 0;
        while (n != 1) {
            //1.用除以10的次数来判断位数
            int length = 0;
            int x = n;
            while (x > 0) {
                x /= 10;
                length++;
            }

            //2.求和
            int temp = 0;
            int sum = 0;
            for (int i = 0; i < length; i++) {
                //个位数是先除以1，等于125再对10取余=5
                //十位数是先除以10，等于12 再对10取余
                temp = (int) (n / (Math.pow(10, i)) % 10);
                sum += temp * temp;
            }
            n = sum;
            count++;
            if (count > 99) {
                return false;
            }
        }
        return true;
    }

}
