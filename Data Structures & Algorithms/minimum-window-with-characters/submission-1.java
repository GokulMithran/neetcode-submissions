class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (m > n)
            return "";

        int[] freq = new int[128];
        int[] winFreq = new int[128];

        for (int i = 0; i < m; i++) {
            freq[t.charAt(i)]++;
        }
        int req = 0;
        for (int i = 0; i < 128; i++) {
            if (freq[i] > 0) {
                req++;
            }
        }
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            winFreq[ch]++;

            if (freq[ch] > 0 && winFreq[ch] == freq[ch]) {
                formed++;
            }

            while (formed == req) {
                int winLen = right - left + 1;
                if (winLen < minLen) {
                    minLen = winLen;
                    start = left;
                }

                char leftChar = s.charAt(left);
                winFreq[leftChar]--;

                if (freq[leftChar] > 0 && winFreq[leftChar] < freq[leftChar]) {
                    formed--;
                }
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE)
            return "";

        return s.substring(start, start + minLen);
    }
}
