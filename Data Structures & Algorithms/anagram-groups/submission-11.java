class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sorted = String.valueOf(ch);

            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }
        return map.values().stream().collect(Collectors.toList());
    }
}
