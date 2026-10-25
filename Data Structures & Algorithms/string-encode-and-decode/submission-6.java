class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            sb.append(len);
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();
        List<String> res = new ArrayList<>();
        int pos = 0;
        while (pos < n) {
            int j = pos;
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(pos,j));
            j++;
            String s = str.substring(j,j+len);
            res.add(s);
            pos = j +len;
        }
        return res;
    }
}
