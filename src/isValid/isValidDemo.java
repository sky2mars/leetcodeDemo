package isValid;

import java.util.ArrayList;

public class isValidDemo {
    public static void main(String[] args) {
        String s= "({[]})";


        ArrayList arr = new ArrayList();
        for (int i = 0;i<s.length();i++){
            int value = getValue(s.charAt(i));
            arr.add(value);
        }

        //如果字符数量为奇数，马上返回false
        if((arr.size()%2)==1){
            System.out.println(1);
        }

        //如果左一半不全为负数，右一半不全为正数，则返回false

        for (int i=0;i<(arr.size()/2);i++){
            if((int)arr.get(i)>0){
                System.out.println(2);
            }

        }
        for (int i = arr.size()/2;i<arr.size();i++){
            if((int)arr.get(i)<0){
                System.out.println(3);
            }
        }

        //左右不对称，返回false
        for(int i =0 ;i<arr.size()/2;i++){
            if((-(int)(arr.get(i)))!=(int)(arr.get(arr.size()-1-i))){
                System.out.println(4);
            }
        }

        System.out.println(true);

    }

    //创建一种返回数字的方法
    public static int getValue(char ch){
        switch (ch){
            case '(':
                return -5;
            case '{':
                return -3;
            case '[':
                return -1;
            case ']':
                return 1;
            case '}':
                return 3;
            case ')':
                return 5;
            default:
                return 0;
        }
    }


}
