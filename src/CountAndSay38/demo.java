package CountAndSay38;

public class demo {
    public static void main(String[] args) {
        System.out.println(countAndSay(8));
    }
    /**
     * 解题思路：
     * 本题的难点在于：报数的概念理解，至少我从题意中没有很清晰的理解，但是感觉像是个递推式
     * 从4->5分析，将4个每一位拆开看（个数+数字），4=1211 => 1=11，2=12，11=21，所以5=111221
     * 所以解题用循环，从1->n可求解出来
     *
     * @param n
     * @return
     */
    public static  String countAndSay(int n) {
        String str = "1";//起始为1
        for (int i = 2; i <= n; i++) {//从2开始循环到n
            StringBuilder builder = new StringBuilder();
            char pre = str.charAt(0); //pre为第i个字符
            int count = 1;
            for (int j = 1; j < str.length(); j++) {//对字符串循环识别
                char c = str.charAt(j);//c从字符串的第二个字符开始识别
                if (c == pre) {//如果相等，则count+1
                    count++;
                } else {//不相等，就把当前的数量和字符存入string builder中
                    builder.append(count).append(pre);
                    pre = c;//同时把下一个字符赋给pre
                    count = 1;//count重新赋值1
                }
            }
            builder.append(count).append(pre);//最后再加入一次sb
            str = builder.toString();
        }


        return str;
    }


}
