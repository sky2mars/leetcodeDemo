package Todo.longestSubstring396;

/**
 * @Author wei
 * @Date 2021/2/27 16:52
 *
 *
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。
 * 返回这一子串的长度。
 *
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 * 1 <= s.length <= 10000
 * s 仅由小写英文字母组成
 * 1 <= k <= 100k
 *
 **/
public class longestSubstring {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();

        long endTome = System.currentTimeMillis();
        System.out.println((endTome - starTime) + "ms");
    }

    public int longestSubstring(String s ,int k){
        //1.用一个map储存并检索每个字母，并且子串不要求连续
        //2.从左往右循环：得出map={c=10,d=11 ...} 集合，
        



        return 0;
    }
}

