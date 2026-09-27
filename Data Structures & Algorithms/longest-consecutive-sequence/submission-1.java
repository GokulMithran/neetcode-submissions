class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        if(n == 0) return 0;

        int prevMax= 0;
        int curMax = 0;

        for(int i = 1;i <n;i++){
            if(nums[i]-nums[i-1] == 1){
                curMax++;
            }else if( nums[i]-nums[i-1] == 0){
                continue;
            }else{
                prevMax = Math.max(curMax,prevMax);
                curMax=0;
            }
        }
        return Math.max(curMax,prevMax)+1;
    }
}
