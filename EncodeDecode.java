import java.util.*;

public class EncodeDecode {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }

        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            encoded.append(s.length()).append('#').append(s);
        }

        return encoded.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            // Step 1: extract the length
            StringBuilder sizeStr = new StringBuilder();
            while (s.charAt(i) != '#') {
                sizeStr.append(s.charAt(i));
                i++;
            }
            i++; // skip the '#'

            int size = Integer.parseInt(sizeStr.toString());
            // Step 2: extract the substring of given size
            String word = s.substring(i, i + size);
            result.add(word);

            i += size; // move index forward
        }

        return result;
    }

    public static void main(String[] args) {
        EncodeDecode sol = new EncodeDecode();

        List<String> strs = Arrays.asList("hello", "world", "this", "is", "java");
        System.out.println("Original Strings: " + strs);

        String encoded = sol.encode(strs);
        System.out.println("Encoded String: " + encoded);

        List<String> decoded = sol.decode(encoded);
        System.out.println("Decoded Strings: " + decoded);
    }
}
