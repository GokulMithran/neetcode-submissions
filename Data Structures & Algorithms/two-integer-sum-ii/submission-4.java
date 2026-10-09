class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        if (n == 0)
            return new int[] {-1, -1};

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }
            if (sum > target)
                right--;
            if (sum < target)
                left++;
        }
        return new int[] {-1, -1};
    }
}
