package June2020.longestCommonPrefix14;

public class longestCommonPrefixDemo {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();
        String[] ss = {"ca", "a"};
        String s = longestCommonPrefix(ss);
        System.out.println(s);
        long endTome = System.currentTimeMillis();
        System.out.println((endTome - starTime) + "ms");
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        String shortest = shorter(strs);
        for (int i = 0; i < shortest.length(); i++) {
            boolean b = true;
            for (int x = 0; x < strs.length; x++) {
                if (shortest.charAt(i) != strs[x].charAt(i)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                sb.append(shortest.charAt(i));
            }
            if (b==false){
                break;
            }

        }

        return sb.toString();
    }

    public static String shorter(String[] strs){
        String temp =strs[0];
        for(int i =1;i<strs.length;i++){
            if(temp.length()>strs[i].length()){
                temp =strs[i];
            }
        }
        return  temp;
    }
}
