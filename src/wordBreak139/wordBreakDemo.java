package wordBreak139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreakDemo {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();
        List<String> list = Arrays.asList("hello", "world","java");
        System.out.println(wordBreak("helloworldhellojava",list));
        long endTome = System.currentTimeMillis();
        System.out.println((endTome - starTime) + "ms");
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);//创建不重复的set集合
        boolean[] dp = new boolean[s.length() + 1];//默认的dp长度
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];//返回
    }

}
