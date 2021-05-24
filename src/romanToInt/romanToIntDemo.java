package romanToInt;

import java.util.ArrayList;

public class romanToIntDemo {
    public static void main(String[] args) {
        String s ="XXIV";

        //第一步解析
        String[] strings = s.split("");
        //把字符转换成数组
        ArrayList arr1 =new ArrayList();
        for(String x:strings){
            if(x.equals("M")){
                arr1.add(7);
            }else if(x.equals("D")){
                arr1.add(6);
            }else if(x.equals("C")){
                arr1.add(5);
            }else if(x.equals("L")){
                arr1.add(4);
            }else if(x.equals("X")){
                arr1.add(3);
            }else if(x.equals("V")){
                arr1.add(2);
            }else{
                arr1.add(1);
            }
        }

        System.out.println(arr1);

        //判断字符是否逆序
        ArrayList arr2= new ArrayList();
        for(int i =0;i<arr1.size()-1;i++){
            int temp1 =0;
            int temp2 =0;

            temp1=(int)arr1.get(i);
            temp2=(int)arr1.get(i + 1);

            if( temp1<temp2 ){//如果逆序，就添加两个，且跳过一个
                arr2.add(temp1*10+temp2);
                i++;
            }
            arr2.add(temp1);//没有逆序，就把当前的加到新数组中

            if(i==arr1.size()-1){//如果跳过2个以后已经到最后一个了，直接把最后一个存入数组
                arr2.add(arr1.get(i));
            }
        }

        System.out.println(arr2);

        //遍历数组2，根据数组的值得到对应的罗马字符并加入到和中
        int sum = 0;
        for(Object o :arr2){
            int x =(int)o;
            switch (x){
                case 7:
                    sum += 1000;
                case 6:
                    sum += 500;
                case 5:
                    sum += 100;
                case 4:
                    sum += 50;
                case 3:
                    sum += 10;
                case 2:
                    sum += 5;
                case 1:
                    sum += 1;
                case 57://cm
                    sum += 900;
                case 56://cd
                    sum += 400;
                case 35://xc
                    sum += 90;
                case 34://xl
                    sum += 40;
                case 13://ix
                    sum += 9;
                case 12://iv
                    sum += 4;
            }
        }

        System.out.println(sum);

    }
}
