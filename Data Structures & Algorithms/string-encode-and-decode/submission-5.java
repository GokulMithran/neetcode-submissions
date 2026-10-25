class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            sb.append(len);
            sb.append("#");
            sb.append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();
        List<String> decode = new ArrayList<>();
        int pos = 0;

        while (pos < n) {
            int j = pos;
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(pos, j));
            j++;
            String s = str.substring(j, len + j);
            decode.add(s);
            pos = j + len;
        }
        System.out.println(decode);
        return decode;
    }
}
