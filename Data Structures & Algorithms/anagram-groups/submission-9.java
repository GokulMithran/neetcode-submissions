class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // 1. Optimize key generation using a frequency count (O(K) instead of O(K log K))
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            
            // Build a unique string representation of the frequency array
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#'); // Separator to prevent overlapping count ambiguities
                sb.append(count[i]);
            }
            String key = sb.toString();

            // 2. Optimize map insertion with computeIfAbsent to avoid multi-pass lookups
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        // 3. Avoid Java Streams overhead by using the ArrayList constructor directly
        return new ArrayList<>(map.values());
    }
}