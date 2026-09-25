class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String s : strs){
            encoded.append(s.length())
                    .append("#")
                    .append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while(i < str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
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
