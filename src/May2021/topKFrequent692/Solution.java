package May2021.topKFrequent692;

import java.util.*;

/**
 * @program: LeetcodeDemo
 * @description:
 * 给一非空的单词列表，返回前 k个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * @Author wei
 * @Date 2021/5/20 10:58
 **/
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        //字符为key，频次为value
        HashMap<String, Integer> dataMap = new HashMap<>();

        //1.统计频次
        for(String word : words){
            //如果还没有这个字符，就添加
            if(!dataMap.containsKey(word)){
                dataMap.put(word,1);
            }else {
                //如果有，就把次数加1
                int i = dataMap.get(word)+1;
                dataMap.put(word,i);
            }
        }

        //2.形成字符集合
        List res = new ArrayList<String>();
        for(String key : dataMap.keySet()){
            res.add(key);
        }

        //3.比较排序
        Collections.sort(res, (Comparator<String>) (word1, word2) -> {
            //单词1和2的频次是否相同？
            //是，用字符的前后顺序排序word1和2
            //否，将word2的频次-word1
            //因为compare中，返回负数不调整顺序，返回正数调整顺序
            return dataMap.get(word1) == dataMap.get(word2) ? word1.compareTo(word2) :
                    dataMap.get(word2) - dataMap.get(word1);
        });

        return res.subList(0, k);
    }

}
