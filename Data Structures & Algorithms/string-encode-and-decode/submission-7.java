class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int n = str.length();
        for (int i = 0; i < n;) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }
            System.out.println("StartIndex:"+ i);
            System.out.println("EndIndex:"+ j);
            System.out.println("StringLength:"+ str.substring(i, j));

            int len = Integer.parseInt(str.substring(i, j));
            j++;
            String s = str.substring(j, j + len);
             System.out.println("String:"+s);
            decoded.add(s);
            i = j + len;
        }
        return decoded;
    }
}
