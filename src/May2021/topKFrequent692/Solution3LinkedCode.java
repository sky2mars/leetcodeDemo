package May2021.topKFrequent692;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @program: leetcodeDemo
 * @description:  链式编程的解法
 * @Author Leetcode-agamem
 * @Date 2021/5/20 16:07
 **/
public class Solution3LinkedCode {
    public List<String> topKFrequent(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                })
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }
}
