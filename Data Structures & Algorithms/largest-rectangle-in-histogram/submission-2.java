class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                int poppedIndex = stack.pop();
                int poppedHeight = heights[poppedIndex];
                int width;
                if (stack.isEmpty())
                    width = i;
                else {
                    width = i - stack.peek() - 1;
                }
                int area = poppedHeight * width;
                maxArea = Math.max(area, maxArea);
            }

            if (i < n)
                stack.push(i);
        }

        return maxArea;
    }
}
