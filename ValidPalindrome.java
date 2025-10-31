public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char left = s.charAt(l);
            char right = s.charAt(r);

            if (!Character.isLetterOrDigit(left)) {
                l++;
            } else if (!Character.isLetterOrDigit(right)) {
                r--;
            } else if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            } else {
                l++;
                r--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();

        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        System.out.println("Input: \"" + s1 + "\" → " + sol.isPalindrome(s1)); // true
        System.out.println("Input: \"" + s2 + "\" → " + sol.isPalindrome(s2)); // false
    }
}
