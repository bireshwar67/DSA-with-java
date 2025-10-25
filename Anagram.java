
//An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
import java.util.HashMap;

public class Anagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }

        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Anagram sol = new Anagram();

        String s1 = "anagram";
        String t1 = "nagaram";

        String s2 = "rat";
        String t2 = "car";

        System.out.println("Is anagram (s1, t1): " + sol.isAnagram(s1, t1)); // true
        System.out.println("Is anagram (s2, t2): " + sol.isAnagram(s2, t2)); // false
    }
}
