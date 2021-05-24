package May2021.SortSentence1859;

import java.util.Arrays;

/**
 * @program: leetcodeDemo
 * @description:
 * @Author wei
 * @Date 2021/5/22 15:04
 **/
public class Solution2 {
        public String sortSentence(String s) {
            // 先切分字符串
            String[] strings = s.split(" ");
            // 对每一个字符串的最后一个字符进行递增排序
            Arrays.sort(strings, (o1, o2) -> {
                return o1.charAt(o1.length() - 1) - o2.charAt(o2.length() - 1);
            });
            StringBuilder builder = new StringBuilder();
            // 拼接字符串，记得删掉末尾的数字
            for (String ss : strings) builder.append(ss, 0, ss.length() - 1).append(" ");
            // 删掉末尾多余的空格再返回
            return builder.substring(0, builder.length() - 1);
        }
}
