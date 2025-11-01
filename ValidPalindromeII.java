public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try skipping one character (either left or right)
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII sol = new ValidPalindromeII();

        String s1 = "abca";
        String s2 = "racecar";
        String s3 = "abc";

        System.out.println("Input: \"" + s1 + "\"\t" + sol.validPalindrome(s1)); // true (remove 'b')
        System.out.println("Input: \"" + s2 + "\"\t" + sol.validPalindrome(s2)); // true
        System.out.println("Input: \"" + s3 + "\"\t" + sol.validPalindrome(s3)); // false
    }
}
