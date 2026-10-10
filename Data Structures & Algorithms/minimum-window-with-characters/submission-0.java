
class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (m > n) {
            return "";
        }

        int[] freq = new int[128];
        int[] windowFreq = new int[128];

        // Count the required characters in t
        for (int i = 0; i < m; i++) {
            freq[t.charAt(i)]++;
        }

        // Count distinct characters that must be satisfied
        int required = 0;
        for (int i = 0; i < 128; i++) {
            if (freq[i] > 0) {
                required++;
            }
        }

        int formed = 0;
        int left = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);

            // Expand: include the right character
            windowFreq[ch]++;

            // Has this character's required frequency just been satisfied?
            if (freq[ch] > 0 && windowFreq[ch] == freq[ch]) {
                formed++;
            }

            // Shrink while the window is valid
            while (formed == required) {
                int windowLen = right - left + 1;

                if (windowLen < minLen) {
                    minLen = windowLen;
                    start = left;
                }

                char leftChar = s.charAt(left);
                windowFreq[leftChar]--;

                // Did removing this character break a requirement?
                if (freq[leftChar] > 0 &&
                    windowFreq[leftChar] < freq[leftChar]) {
                    formed--;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}
