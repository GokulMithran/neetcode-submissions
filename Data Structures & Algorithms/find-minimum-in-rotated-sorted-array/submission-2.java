class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int med=left+((right-left)/2);

        while(left<right){
            med=left+((right-left)/2);
            if(nums[left]<=nums[med]&&nums[med]<nums[right])
                return nums[left];
            if(nums[left]>nums[med])
                right=med;
            else if(nums[right]<nums[med])
                left=med+1;
        }
        return nums[left];
    }
}
