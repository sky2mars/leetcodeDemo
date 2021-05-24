package maxProfit121;

public class maxProfitDemo {
    public static void main(String[] args) {
        long starTime = System.currentTimeMillis();
        int[] arr = {6,3,4,8,9};
        int i = maxProfit(arr);
        System.out.println(i);
        long endTome = System.currentTimeMillis();
        System.out.println((endTome - starTime) + "ms");
    }

    public static int maxProfit(int[] prices) {
        int maxPrice = 0;
        for (int i =0;i<prices.length-1;i++){
            for(int j = i+1;j<prices.length;j++){
                int temp = prices[j]-prices[i];
                if(temp>maxPrice){
                    maxPrice = temp;
                }
            }
        }
        return maxPrice;
    }
}
