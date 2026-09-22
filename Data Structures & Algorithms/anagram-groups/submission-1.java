class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

      Map<String,List<String>>  map = new HashMap<>();
    
      for(String s: strs){
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        String key = Arrays.toString(count);
        if(map.containsKey(key)){
            map.get(key).add(s);
        }else{
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
      }
    return new ArrayList<>(map.values());
    }
}
