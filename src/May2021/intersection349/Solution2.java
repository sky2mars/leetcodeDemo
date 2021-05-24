package May2021.intersection349;

import java.util.Arrays;

/**
 * @program: leetcodeDemo
 * @description: 双指针法
 * 两个指针分别指向两个数组的头部。
 * 每次比较两个指针指向的两个数组中的数字，如果两个数字不相等，则将指向较小数字的指针右移一位，如果两个数字相等，
 * 且该数字不等于 *pre* ，将该数字添加到答案并更新 *pre* 变量，同时将两个指针都右移一位。
 * 当至少有一个指针超出数组范围时，遍历结束。
 * @Author wei
 * @Date 2021/5/24 16:25
 **/
public class Solution2 {
    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了95.28% 的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了24.63% 的用户
     * */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //创建数组
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];

        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];

            if (num1 == num2) {
                // 保证加入元素的唯一性
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
                //不等就移动指针
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }


}
