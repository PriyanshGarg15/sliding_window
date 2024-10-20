

import java.util.HashSet;

public class a6_longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        a6_longest_substring_without_repeating_characters solution = new a6_longest_substring_without_repeating_characters();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));  // Output: 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));     // Output: 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));    // Output: 3
    }
}
