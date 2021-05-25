package May2020.twoSum1;

import java.util.Arrays;

public class twoSumDemo {
    public static void main(String[] args) {
        int arr []= {2,7,9,12,13,15};

        int[] sum = twoSum(arr, 16);

        System.out.println(Arrays.toString(sum));
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int x=i+1;x<nums.length;x++){
                if(nums[i]+nums[x]==target){
                    int[] sum = {i,x};
                    return sum;
                }
            }
        }
        return new int[]{0,0};
    }
}
