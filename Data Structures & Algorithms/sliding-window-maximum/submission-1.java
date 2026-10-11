class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int j = 0;
        // Store indices, not values
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Step 1: Remove indices outside the window
            while (!deque.isEmpty()
                    && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Step 2: Remove smaller or equal values
            // from the back of the deque
            while (!deque.isEmpty()
                    && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Step 3: Add current index
            deque.offerLast(i);

            // Step 4: Record maximum when window is ready
            if (i >= k - 1) {
                result[j++]= nums[deque.peekFirst()];
            }
        }

        return result;
    }
}