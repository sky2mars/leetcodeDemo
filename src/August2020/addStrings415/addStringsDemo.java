package August2020.addStrings415;

public class addStringsDemo {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();
        //char a = '0';
        //char b = '1';
        //System.out.println((a-48));
        System.out.println(addStrings("0","0"));
        long endTome = System.currentTimeMillis();
        System.out.println((endTome - starTime) + "ms");
    }

    public static String addStrings(String num1, String num2) {
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        //"1231243535234"
        //"5345234241245645745634525234143"
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        int sum = 0;
        String returnString = "";
        boolean stepOne = false;

        //这一步把其中一个的索引消耗为0
        while (index1>=0&&index2>=0){
            //判断是否要进1
            if(stepOne){
                sum = num1Array[index1]-48 + num2Array[index2]-48 +1;
                stepOne = false;//进1之后改为false
            }else {
                sum = num1Array[index1] -48 + num2Array[index2]-48;
            }

            //由于num的长度可能超出int范围，所以得到的值直接转为字符串
            if(sum<10){
                String s = String.valueOf(sum);
                returnString = s + returnString;
            }else {
                stepOne = true;
                String s = String.valueOf(sum % 10);//取个位
                returnString = s + returnString;
            }

            index1--;
            index2--;
        }

        //剩下的另一部分直接黏贴即可
        //判断谁的索引还>=0,就对哪个字符串操作
        if(index1>=0){//数字1进1
            String left = num1.substring(0, index1);
            if(stepOne){//是否需要进1
                //先黏上最后一个字符
                char[] leftArray = left.toCharArray();
                int leftIndex = left.length()-1;
                char c = leftArray[leftIndex];
                String s = String.valueOf(c - 47);
                returnString = s + returnString;

                //再粘剩下的字符
                String left2 = num1.substring(0, index1-1);
                returnString = left2 + returnString;
            }else {
                returnString = left + returnString;
            }

        }else {//数字2进1
            String left = num2.substring(0, index2);
            if(stepOne){//是否需要进1
                //先黏上最后一个字符
                char[] leftArray = left.toCharArray();
                int leftIndex = left.length()-1;
                char c = leftArray[leftIndex];
                String s = String.valueOf(c - 47);
                returnString = s + returnString;

                //再粘剩下的字符
                String left2 = num1.substring(0, index1-1);
                returnString = left2 + returnString;
            }else {
                returnString = left + returnString;
            }
        }

        return returnString;
    }

    //标准答案
    public String addStrings2(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }


}
