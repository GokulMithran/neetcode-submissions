class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length == 0)
        return false;
        Arrays.sort(nums);
        int dup=nums[0];
        for(int i = 1; i< nums.length;i++){
            if(dup == nums[i]){
                return true;
            }else{
                dup=nums[i];
            }
        }
        return false;
    }
}