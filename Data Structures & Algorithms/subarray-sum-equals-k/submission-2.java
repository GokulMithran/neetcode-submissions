class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int pre = 0;
        map.put(0, 1);
        for (int num : nums) {
            pre += num;

            int needed = pre - k;

            count+= map.getOrDefault(needed,0);

            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
