package May2021.intersection349;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @program: leetcodeDemo
 * @description: 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * @Author wei
 * @Date 2021/5/24 15:25
 **/
public class Solution {

    /**
    * 	4 ms	38.6 MB
    **/
    public static int[] intersection(int[] nums1, int[] nums2) {
        //建立一个map，key为数字
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums1) {
            map.put(num, 1);
        }

        //如果有重复的，value就加一
        for (Integer num : nums2) {
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
        }

        //输出value > 1的所有key
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            if (map.get(key) > 1) {
                list.add(key);
            }
        }

        //初始化需要得到的数组
        int[] rev = new int[list.size()];

        //使用for循环得到数组
        for (int i = 0; i < list.size(); i++) {
            rev[i] = list.get(i);
        }

        return rev;
    }

    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();

        int [] num1 = {4,9,5};
        int [] num2 = {9,4,9,8,4};
        System.out.println(intersection(num1,num2));

        long endTome = System.currentTimeMillis();
        System.out.println((endTome - starTime) + "ms");
    }

}
