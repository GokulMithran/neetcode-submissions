class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0) return 0;
        int max = 0;
        int prev =0;
       for(int i=0;i<n;i++){
         for(int j =i+1;j<n;j++){
            max = Math.max(max, prices[j]-prices[i]);
         }
       } 
       return max;
    }
}
