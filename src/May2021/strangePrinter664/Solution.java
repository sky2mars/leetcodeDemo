package May2021.strangePrinter664;

/**
 * @program: leetcodeDemo
 * @description:
 * > 有台奇怪的打印机有以下两个特殊要求：
 * > 1. 打印机每次只能打印由 **同一个字符** 组成的序列。
 * > 2. 每次可以在任意**起始和结束位置**打印新字符，并且会覆盖掉原来已有的字符。
 *
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的**最少打印次数**。
 * @Author wei
 * @Date 2021/5/24 20:08
 *
 * 执行用时：15 ms, 在所有 Java 提交中击败了82.71% 的用户
 * 内存消耗：38 MB, 在所有 Java 提交中击败了99.25% 的用户
 **/
public class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        //f[i][j]为i到j索引区间可能的打印次数
        int[][] f = new int[n][n];
        //i从大到小，j从小到大，因为i>j的部分是无意义的
        for (int i = n - 1; i >= 0; i--) {
            //边界条件为 f[i] [i]=1，对于长度为 1 的区间，需要打印 1 次。
            f[i][i] = 1;

            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    //如果左右两侧相等，则同时打印
                    f[i][j] = f[i][j - 1];
                } else {
                    int minn = Integer.MAX_VALUE;
                    //k从i到j，找出不同组会打印次数最少的选择
                    for (int k = i; k < j; k++) {
                        //动态规划：递归调用
                        minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = minn;
                }
            }
        }

        //最后的答案为 f[0][n−1],即右上角的次数。
        return f[0][n - 1];
    }
}
