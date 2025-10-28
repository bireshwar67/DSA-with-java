import java.util.*;

public class TinyUrlCodec {

    private Map<String, String> longToShort = new HashMap<>();
    private Map<String, String> shortToLong = new HashMap<>();
    private int id = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return longToShort.get(longUrl);
        }

        String shortUrl = "http://tinyurl.com/" + id++;
        longToShort.put(longUrl, shortUrl);
        shortToLong.put(shortUrl, longUrl);

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.getOrDefault(shortUrl, "");
    }

    public static void main(String[] args) {
        TinyUrlCodec codec = new TinyUrlCodec();

        String longUrl = "https://www.leetcode.com//problems/design-tinyurl";
        System.out.println("Original URL: " + longUrl);

        String shortUrl = codec.encode(longUrl);
        System.out.println("Shortened URL: " + shortUrl);

        String decodedUrl = codec.decode(shortUrl);
        System.out.println("Decoded URL: " + decodedUrl);
    }
}
