class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int left = 1;
        leftSum[0] = left;
        for (int i = 0; i < n; i++) {
            leftSum[i] = left;
            left = nums[i] * left;
        }
        int right = 1;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = right * leftSum[i];
            right = right * nums[i];
        }
        return res;
    }
}
