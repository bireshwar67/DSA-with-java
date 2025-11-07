import java.util.*;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int required = tFreq.size();
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        int l = 0, r = 0;

        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (tFreq.containsKey(c) && windowCounts.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window when valid
            while (l <= r && formed == required) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minLeft = l;
                }

                char leftChar = s.charAt(l);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (tFreq.containsKey(leftChar) && windowCounts.get(leftChar) < tFreq.get(leftChar)) {
                    formed--;
                }
                l++;
            }

            r++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println("Input String: " + s);
        System.out.println("Target: " + t);
        System.out.println("Minimum Window Substring: " + sol.minWindow(s, t));
    }

}
