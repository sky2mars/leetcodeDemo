package longestPalindrome5;

public class longestPalindromeDemo {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();
        //String s = "abcd";
        System.out.println(5/2);
        //System.out.println(s.substring(1,2));
        System.out.println(longestPalindrome2("xabcdcbay"));
        //System.out.println(isPalindrome("a"));
        long endTome = System.currentTimeMillis();
        System.out.println((endTome - starTime) + "ms");
    }

    /*
    * 根据回文字符的特点，左右对称，指针从左右分别开始(left=0,right=s.size-1)，向中间靠拢
    * " x abcdefgfedcba uio"
    * left从'x'开始，right从右向左扫描，看是否能找到'x'
    * 找不到，则left向右移动一位，left = 'a'
    * right 从右向左扫描，看是否能找到 ‘a’ ，找到'a'后，截取这段字符串，判断是否为回文数，是的话就存储在max中
    * 这样找出的回文数是最大的吗？否。 如：bccccbccccxyz
    * */
    public static String longestPalindrome(String s) {
        String longestString = "";
        for(int left = 0;left<s.length();left++){
            for(int right = s.length()-1;right>=left;right--){
                if (s.charAt(left)==s.charAt(right)){
                    String temp = s.substring(left, right+1);
                    if(isPalindrome(temp)){
                        if(temp.length()>longestString.length()){
                            longestString=temp;
                        }
                    }
                }
            }
        }


        return longestString;
    }

    public static boolean isPalindrome(String s){
        int length = s.length();
        int half = length/2;
        for(int i = 0;i<half;i++){
            if(s.charAt(i) != s.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }


    //中心扩展法
    //我们知道回文串一定是对称的，所以我们可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);//回文字符中心是一个字符的情况
            int len2 = expandAroundCenter(s, i, i + 1);//回文字符中心是两个字符的情况
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {//返回回文字符串的长度
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


}
