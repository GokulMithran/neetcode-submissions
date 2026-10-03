class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0)
            return 0;

        int left = 0;
        int right = n - 1;
        int lMax = 0;
        int rMax = 0;
        int sum = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= lMax) {
                    lMax = height[left];
                } else {
                    sum += lMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rMax) {
                    rMax = height[right];
                } else {
                    sum += rMax - height[right];
                }
                right--;
            }
        }

        return sum;
    }
}
