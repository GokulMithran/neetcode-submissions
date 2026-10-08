class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        int left = 0;
        int right = n - 1;

        while (left < right) {
            while(left < right && !isAlphaNumeric(s.charAt(left))){
                left++;
            }
            while(left < right && !isAlphaNumeric(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left))!=
            Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isAlphaNumeric(char c) {
        return isAlphabet(c) || isDigit(c);
    }

    public static boolean isAlphabet(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
