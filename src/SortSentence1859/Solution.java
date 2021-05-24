package SortSentence1859;

import java.util.*;

/**
 * @program: leetcodeDemo
 * @description: 1859.将句子排序
 * 输入：s = "is2 sentence4 This1 a3"
 * 输出："This is a sentence"
 * 解释：将 s 中的单词按照初始位置排序，得到 "This1 is2 a3 sentence4" ，然后删除数字
 * <p>
 * 2 <= s.length <= 200
 * s 只包含小写和大写英文字母、空格以及从 1 到 9 的数字。
 * s 中单词数目为 1 到 9 个。
 * s 中的单词由单个空格分隔。
 * s 不包含任何前导或者后缀空格。
 * @Author wei
 * @Date 2021/5/22 11:54
 **/
public class Solution {
    public String sortSentence(String s) {
        //1.解析输入的句子，储存对应的字符与数字
        String[] words = s.split(" ");

        HashMap<Integer, String> map = new HashMap<>();
        for (String word : words) {
            Integer key = word.charAt(word.length()-1)-'0';
            //substring的参数为 起始位置，偏移量
            String value = word.substring(0,word.length()-1);
            map.put(key,value);
        }

        //2.根据数字排序
        //3.形成key的集合
        ArrayList<Integer> keyList = new ArrayList<>();
        for(Integer key : map.keySet()) {
            keyList.add(key);
        }
        Collections.sort(keyList);

        //3.返回字符串，并把数字删除
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ;i<keyList.size();i++){
            if(i==keyList.size()-1){
                stringBuilder.append(map.get(keyList.get(i)));
            }else {
                stringBuilder.append(map.get(keyList.get(i))+" ");
            }
        }

        return stringBuilder.toString();
    }
}
