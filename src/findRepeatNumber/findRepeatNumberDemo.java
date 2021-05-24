package findRepeatNumber;

/*
*请找出数组中任意一个重复的数字。
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3
*
* */

import java.util.HashSet;

public class findRepeatNumberDemo {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();
        int [] arr = {0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,16,17,18,19,20,20};
        System.out.println(findRepeatNumber(arr));
        long endTome = System.currentTimeMillis();
        System.out.println((endTome - starTime) + "ms");

    }

    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)){
                return num;
            }
        }
        return -1;
    }

    public static int findRepeatNumber1(int[] nums) {
        for(int i = 0 ;i<nums.length;i++){
            for(int x =i+1;x<nums.length;x++){
                if(nums[i]==nums[x]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
