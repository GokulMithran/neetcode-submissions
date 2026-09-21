class Solution {
    public int[] twoSum(int[] nums, int target) {
       int len = nums.length;
       Map<Integer,Integer> prevMap = new HashMap<>();
       for(int i = 0;i <len;i++){
        int diff = target - nums[i];

        if(prevMap.containsKey(diff)){
            return new int[]{prevMap.get(diff),i};
        }
        prevMap.put(nums[i],i);
       }    
       return new int[]{-1,-1}; 
    }
}
