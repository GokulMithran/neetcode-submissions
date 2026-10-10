class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        if (n == 0)
            return 0;

        int left = 0;
        int right = n - 1;
        int max = 0;
        int minHeight = 0;
        while (left < right) {
            minHeight = Math.min(heights[left], heights[right]);
            max = Math.max(max, minHeight * (right - left));
            if (heights[left] < heights[right]) {
                left++;

            } else {
                right--;
            }
        }
        return max;
    }
}
