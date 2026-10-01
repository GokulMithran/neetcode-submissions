class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n - 1;
        int max = 0;
        while (left < right) {
            int curr = 0;
            int val=0;

            if (heights[left] < heights[right]) {
                val = Math.min(heights[left], heights[right]);
                curr = val * (right-left);
                left++;
            } else {
                val = Math.min(heights[left], heights[right]);
                curr = val * (right-left);
                right--;
            }
            max = Math.max(curr, max);
        }
        return max;
    }
}
