class Solution {

    public String encode(List<String> strs) {
        StringBuilder encode= new StringBuilder();
        for(String s: strs){
             encode.append(s.length())
                   .append("#")
                   .append(s);    
        }
        return encode.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j  = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            j++;
            String s = str.substring(j,j+len);
            res.add(s);
            i = j + len;
        }
        return res;
    }
}
