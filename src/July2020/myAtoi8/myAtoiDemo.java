package July2020.myAtoi8;

public class myAtoiDemo {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();
        //System.out.println(subSting("+"));
        System.out.println(myAtoi2("   123"));
        //System.out.println(-2147483648/10);
        long endTome = System.currentTimeMillis();
        System.out.println((endTome - starTime) + "ms");
    }

    /*
    * 1. 去除字符前面的空格
    * 2. 第一个字符如果非数字，返回0
      3. 第一个字符是 +/- ，将它和后面的数字拼接起来
      4. 第一个字符是数字，截取到非数字部分
      5. 超出int范围，返回intMax 或 intMIn
      * 不能转换的，都返回0。
    * */
    public static int myAtoi(String str) {
        if(str.length()==0){
            return 0;
        }

        String sub = subSting(str);
        String ret = "";

        if(sub.length()==0){
            return 0;
        }

        //对最前面有+-的处理
        if(sub.charAt(0)==43 || sub.charAt(0)==45 ){
            ret += sub.charAt(0);
            if(sub.length()<2){
                return 0;
            }else {
                sub = sub.substring(1);
            }
        }

        //第一个字符如果不是数字，直接返回0
        if(sub.charAt(0)<48 || sub.charAt(0)>57){
            return 0;
        }

        //现在已经确保了，非空、去掉了+-，至少第一个字符是数字
        for(int i= 0;i<sub.length();i++){
            char x = sub.charAt(i);
            if(x>47&&x<58){
                ret += x;
            }else {
                break;
            }
        }


        //有可能超出long的范围(10^19左右)
        if(ret.length()>19){
            if(ret.charAt(0)==45){
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }
        }

        //对ret处理，首先是转成数字，再限制范围，再返回
        long longRet = Long.parseLong(ret);
        if(longRet>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(longRet<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else {
            return (int) longRet;
        }

    }



    //去除字符前面的空格，并把后面的的空格截断
    public static String subSting(String s){
        String left = "";
        for(int i= 0;i<s.length();i++){
            char x = s.charAt(i);
            if(x == 32){
                continue;
            }else {
                left = s.substring(i);
                break;
            }
        }

        if(left.length()!=0) {
            for (int i = 0; i < left.length(); i++) {
                if (left.charAt(i) == 32) {
                    return left.substring(0, i);
                }
            }
        }

        return left;
    }

    //官方解法
    public static int myAtoi2(String str){
        if(str.length()==0){return 0; }//对空字符串的处理
        int res = 0;//默认返回值
        int i = 0;//循环数
        int flag=1;//默认正负
        while (str.charAt(i)== 32) {
            i++;
            if(i==str.length()){return 0;}//如果i推到最后一位，说明全部是空格，返回0
        }//如果是空格，就把i往前推，即去除前空格
        if(str.charAt(i) == 45){flag=-1;}//如果非空格的第一位是 - ，则把flag改为负数
        if(str.charAt(i)== 43 || str.charAt(i) == 45){i++;}//如果第一位是正负号，向后推一位
        while (i<str.length()&& Character.isDigit(str.charAt(i))){//当i小于总长度，s[i]且是数字
            int r = str.charAt(i) - '0';//char和int的转换，i的字符码减去0的字符码刚好是它本身的大小
        // 检查是否越界，即，这时候如果res已经大于214748364(214748365*10 越界)，或res=214748364且r>7,-2147483648刚好返回最小值
            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && r>7 )){
                return flag>0? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res*10 +r;//向左推一位，再加上r
            i++;
        }
        return flag>0? res : -res;
    }
}
