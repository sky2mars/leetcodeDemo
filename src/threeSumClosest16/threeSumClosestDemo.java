package threeSumClosest16;

import java.util.HashSet;

public class threeSumClosestDemo {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();

        int [] arr ={-1,2,1,-4};
        System.out.println(threeSumClosest(arr,1));

        long endTome = System.currentTimeMillis();
        System.out.println((endTome - starTime) + "ms");
    }

    //暴力法
    public static int threeSumClosest(int[] nums, int target) {
        HashSet<Integer> closestSet = new HashSet<>();
        //创建三个循环嵌套，添加所有的值
        for(int x = 0;x<nums.length;x++){
            for (int y= x+1;y<nums.length;y++){
                for(int z = y+1;z<nums.length;z++){
                    closestSet.add(nums[x]+nums[y]+nums[z]);
                }
            }
        }


        //对比寻找出最接近的值
        int value = 0 ;
        int closest = 10000;
        for(int i :closestSet){
            if(Math.abs(i-target)<Math.abs(closest-target)){
                closest = i;
            }
        }

        return closest;
    }

}
