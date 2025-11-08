import java.util.*;

public class RepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int left = 0;
        int ans = 0;
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(c));

            // If current window is invalid, shrink from left
            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        RepeatingCharacterReplacement sol = new RepeatingCharacterReplacement();

        String s = "AABABBA";
        int k = 1;

        System.out.println("Input String: " + s);
        System.out.println("k = " + k);
        System.out.println("Longest substring after replacement: " + sol.characterReplacement(s, k));
    }
}
