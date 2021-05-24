package May2020.rob198;

public class robDemo {
    public static void main(String[] args) {
        int nums[]={2,1,1,2};

        //边界条件
        //增强稳定性，如果数组为空或不存在，直接返回0
        if(nums.length==0||nums == null){
            System.out.println(0);
        }
        //如果数组长度为1，返回这个数字
        if(nums.length==1){
            System.out.println(nums[0]);
        }

        //开始循环
        int max1= nums[0];
        int max2 = Math.max(nums[0],nums[1]);
        //从第三个数开始循环
        for (int i = 2 ; i < nums.length;i++){
            int temp=nums[i]+max1;
            //max2 永远是最大的一个数，max1则变化为i-1
            max1=max2;
            if (temp>max2 ){//temp为加上的情况，如果大于max2，则将它赋值给max2
                max2=temp;
            }
            //如果小于等于，则max2的值不变
        }

        System.out.println(max2);
    }
}
