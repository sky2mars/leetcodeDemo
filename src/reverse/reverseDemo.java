package reverse;

public class reverseDemo {
    public static void main(String[] args) {
        int x = 2147483647;
        String s = new StringBuilder(String.valueOf(x)).reverse().toString();
        long i = Long.parseLong(s);
        if(i>x){
            System.out.println(true);
        }
        System.out.println(i);
    }
}
