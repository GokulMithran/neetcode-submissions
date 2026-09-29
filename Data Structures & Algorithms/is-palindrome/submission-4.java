class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder str = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (c >= 'a' && c <= 'z') {
                str.append(c);
            }
            else if (c >= 'A' && c <= 'Z') {
                str.append(Character.toLowerCase(c));
            }
            else if (c >= '0' && c <= '9') {
                str.append(c);
            }
        }

        String st = str.toString();

        int start = 0;
        int end = st.length() - 1;

        while (start < end) {

            if (st.charAt(start) != st.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}