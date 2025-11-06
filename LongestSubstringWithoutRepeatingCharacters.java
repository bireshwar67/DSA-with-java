import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, right = 0;
        int n = s.length();
        int maxLen = 0;

        while (right < n) {
            if (!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                seen.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();

        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println("Input: \"" + s1 + "\" " + sol.lengthOfLongestSubstring(s1)); // 3
        System.out.println("Input: \"" + s2 + "\" " + sol.lengthOfLongestSubstring(s2)); // 1
        System.out.println("Input: \"" + s3 + "\" " + sol.lengthOfLongestSubstring(s3)); // 3
    }
}
