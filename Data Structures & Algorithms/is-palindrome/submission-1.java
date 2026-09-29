class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                str.append(Character.toLowerCase(c));
            };
            if(c>='0' && c<='9') str.append(c);
        }
        System.out.println(str.toString());

        String st = str.toString();
        int n = st.length();
        int start = 0;
        int end = n-1;

        while(start<n && end>=0){
            if(start == end) return true;
            if(st.charAt(start) != st.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}
