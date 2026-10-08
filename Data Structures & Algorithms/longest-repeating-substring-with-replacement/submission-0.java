class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {

            // Add current character
            freq[s.charAt(right) - 'A']++;

            // Highest frequency character in the window
            maxFreq = Math.max(
                maxFreq,
                freq[s.charAt(right) - 'A']
            );

            // Shrink window if too many replacements are needed
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Current window is valid
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}