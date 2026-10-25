class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        left[0] = 1;
        int l = 1;
        for (int i = 1; i < n; i++) {
            l = l * nums[i - 1];
            left[i] = l;
        }
        // IntStream.range(0, n)
        //          .forEach(i -> System.out.println("Index " + i + " -> " + left[i]));
        int right = 1;
        int[] res = new int[n];
        res[n - 1] = right * left[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right = right * nums[i + 1];

            res[i] = right * left[i];
        }
        return res;
    }
}
