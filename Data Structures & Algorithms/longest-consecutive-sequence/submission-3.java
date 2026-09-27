class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int lon = 0;
        if (n == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int len = 1;

                while (set.contains(cur + 1)) {
                    len++;
                    cur++;
                }
                lon = Math.max(len, lon);
            }
        }
        return lon;
    }
}
