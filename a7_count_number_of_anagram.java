
import java.util.HashMap;

public class a7_count_number_of_anagram {
    public static int countAnagrams(String target, String s) {
        if (target.length() > s.length()) return 0;
        HashMap<Character, Integer> targetCount = new HashMap<>();
        for (char c : target.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> windowCount = new HashMap<>();
        int windowSize = target.length();
        int anagramCount = 0;
        for (int i = 0; i < windowSize; i++) {
            windowCount.put(s.charAt(i), windowCount.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (targetCount.equals(windowCount)) {
            anagramCount++;
        }
        for (int i = windowSize; i < s.length(); i++) {
            char newChar = s.charAt(i);
            char oldChar = s.charAt(i - windowSize);
            windowCount.put(newChar, windowCount.getOrDefault(newChar, 0) + 1);
            windowCount.put(oldChar, windowCount.get(oldChar) - 1);
            if (windowCount.get(oldChar) == 0) {
                windowCount.remove(oldChar);
            }
            if (targetCount.equals(windowCount)) {
                anagramCount++;
            }
        }

        return anagramCount;
    }

    public static void main(String[] args) {
        String target = "ab";
        String s = "abab";
        System.out.println(countAnagrams(target, s)); // Output: 2

        target = "abc";
        s = "cbabcacab";
        System.out.println(countAnagrams(target, s)); // Output: 3
    }
}
