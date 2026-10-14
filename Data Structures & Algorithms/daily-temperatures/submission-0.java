class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        if (n == 0)
            return new int[] {};
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}
