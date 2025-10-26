import java.util.*;

public class GrpAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);                // Sort characters to form the key
            String key = new String(chars);

            // Add to the corresponding group
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        GrpAnagram sol = new GrpAnagram();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = sol.groupAnagrams(strs);

        System.out.println("Grouped Anagrams: " + result);
    }
}