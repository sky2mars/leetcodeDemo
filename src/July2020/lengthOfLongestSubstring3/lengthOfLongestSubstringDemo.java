package July2020.lengthOfLongestSubstring3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lengthOfLongestSubstringDemo {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();

        System.out.println(lengthOfLongestSubstring2("abcaecdd"));

        long endTome = System.currentTimeMillis();
        System.out.println((endTome - starTime) + "ms");
    }

    public static int lengthOfLongestSubstring(String s) {
        List<HashSet<Character>> list = new ArrayList<>();
        for(int x=0;x<s.length();x++) {
            //得到不含重复元素的set
            HashSet<Character> set = new HashSet<>();
            for (int i = x; i < s.length(); i++) {
                if (!set.add(s.charAt(i))) {
                    break;
                }
            }
            list.add(set);
        }
        //循环判断
        int maxSize = 0;
        for(HashSet set : list){
            if(set.size()>maxSize){
                maxSize=set.size();
            }
        }
        return maxSize;
    }

    //滑动窗口
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();//键为字符，值为int
        int max = 0;
        int left = 0;
        //“abcaecdd”
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){//2.如果键中包括了这个字符，则在map中找到这个字符，并让left在这个字符之后
                left = Math.max(left,map.get(s.charAt(i)) + 1);//
                                //0 和 map.get(a)=0 +1  中的较大值 ，这样左变成1窗口向右滑动
            }
            map.put(s.charAt(i),i);//1.不重复，键为字符，值为索引位置   //3.继续把a作为键放入，只是这时候值变为3
            max = Math.max(max,i-left+1);//.最大长度为结束的索引-左侧索引+1
        }
        return max;
        //“abcaecdd”
        //left=0,{a=0},max=1
        //left=0,{a=0,b=1},max=2
        //left=0,{a=0,b=1,c=2},max=3
        //left=1,{a=3,b=1,c=2},max=3,left向右滑动一格
    }
}
