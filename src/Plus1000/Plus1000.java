package Plus1000;

/**
 * @Author wei
 * @Date 2021/2/22 17:13
 **/
public class Plus1000 {
    //求 a+b+c=1000 且 a^2 + b^2 = c^2 ,即周长为1000的直角三角形（边长为整数）

    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();

        //三层嵌套：
        //i:200 j:375 k:425
        //244ms
        for(int i=1;i<=1000;i++){
            for(int j =i;j<=1000;j++){
                for (int k=j;k<=1000;k++){
                    if(i+j+k==1000 && ((Math.pow(i,2)+Math.pow(j,2)) == Math.pow(k,2))){
                        System.out.println("i:"+i+" j:"+j+" k:"+k);
                    }
                }
            }
        }


        //减少一层嵌套
        //i:200 j:375 k:425
        //31ms
      /*  for(int i=1;i<=1000;i++){
            for(int j =i;j<=1000;j++){
                    if(((Math.pow(i,2)+Math.pow(j,2)) == Math.pow(1000-i-j,2))){
                        System.out.println("i:"+i+" j:"+j+" k:"+(1000-i-j));
                    }
            }
        }*/

        long endTome = System.currentTimeMillis();
        System.out.println((endTome - starTime) + "ms");
    }
}
