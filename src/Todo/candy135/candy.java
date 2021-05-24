package Todo.candy135;

public class candy {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();

        int[] ratings= {1,2,3,2,1};

        System.out.println(candy(ratings));


        long endTome = System.currentTimeMillis();
        System.out.println((endTome - starTime) + "ms");
    }




    public static int candy(int[] ratings){
        if(ratings.length==0){return 0;}
        if(ratings.length==1){return 1;}


        int result = 0;
        boolean isRise ;
        if (ratings[1]>ratings[0]){
            isRise=true;
        }else {
            isRise=false;
        }

        int counter = 1;

        for(int i = 1;i<ratings.length;i++) {

            if (isRise = true) {
                if (ratings[i ] > ratings[i-1]) {
                    counter++;
                } else {//转折的时候，把计数器的值加到结果中
                    isRise = false;
                    result += sumOfN(counter);
                    counter = 1;
                }
            } else {
                if (ratings[i ] < ratings[i-1]) {
                    counter++;
                } else {
                    isRise = true;
                    result += sumOfN(counter);
                    counter = 1;
                }
            }

            if (i==ratings.length-1){
                result += sumOfN(counter);//最后一步的也要加上，此时没有转折了
            }
        }


        return result;
    }

    public static int sumOfN(int n){
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
}
