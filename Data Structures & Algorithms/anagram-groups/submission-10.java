class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (map.containsKey(sorted)) {
                map.get(sorted).add(s);
            } else {
                map.put(sorted, new ArrayList<>());
                map.get(sorted).add(s);
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }
}   
