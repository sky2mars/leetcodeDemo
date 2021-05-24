package May2021.topKFrequent692;

import java.util.*;

/**
 * @program: leetcodeDemo
 * @description:
 * @Author wei
 * @Date 2021/5/20 15:49
 **/
public class Solution2 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        //1.计数
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        //2.获取所有字符
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }

        //3.排序
        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                //单词1和2的频次是否相同？
                //是，用字符的前后顺序排序word1和2
                //否，将word2的频次-word1
                //因为compare中，返回负数不调整顺序，返回正数调整顺序
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        return rec.subList(0, k);
    }
}
