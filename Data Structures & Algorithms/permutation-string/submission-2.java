class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m)
            return false;
        int[] freq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(freq, windowFreq))
            return true;

        for (int right = n; right < m; right++) {
            windowFreq[s2.charAt(right) - 'a']++;
            windowFreq[s2.charAt(right - n) - 'a']--;
            if (Arrays.equals(freq, windowFreq))
                return true;
        }
        return false;
    }
}
