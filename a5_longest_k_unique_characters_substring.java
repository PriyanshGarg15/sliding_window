// package sash_coding;
// import java.util.*;
// public class a5_longest_k_unique_characters_substring {
//     public static void main(String[] args) {
//         String str = "aabbcc";
//         int k = 2;  // Example input: Find the longest substring with 2 unique characters
//         String longestSubstring = findLongestKUniqueSubstring(str, k);
//         System.out.println("Longest substring with " + k + " unique characters: " + longestSubstring);
//     }

//     public static String findLongestKUniqueSubstring(String str, int k) {
//         int maxLength = 0;
//         String longestSubstring = "";

//         for (int i = 0; i < str.length(); i++) {
//             for (int j = i; j < str.length(); j++) {
//                 String subStr = str.substring(i, j + 1);

//                 // Check if the substring has exactly 'k' unique characters
//                 if (hasKUniqueCharacters(subStr, k)) {
//                     if (subStr.length() > maxLength) {
//                         maxLength = subStr.length();
//                         longestSubstring = subStr;
//                     }
//                 }
//             }
//         }
//         return longestSubstring;
//     }

//     // Helper function to check if a string has exactly 'k' unique characters
//     public static boolean hasKUniqueCharacters(String str, int k) {
//         HashSet<Character> uniqueChars = new HashSet<>();
//         for (char c : str.toCharArray()) {
//             uniqueChars.add(c);
//         }
//         return uniqueChars.size() == k;
//     }
// }

import java.util.*;
public class a5_longest_k_unique_characters_substring {

    public static void main(String[] args) {
        String str = "aabbcc";
        int k = 2;  
        String longestSubstring = findLongestKUniqueSubstring(str, k);
        System.out.println("Longest substring with " + k + " unique characters: " + longestSubstring);
    }

    public static String findLongestKUniqueSubstring(String str, int k) {
        int left = 0, right = 0, maxLength = 0, start = 0;
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        while (right < str.length()) {
            char rightChar = str.charAt(right);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);
            while (charFrequency.size() > k) {
                char leftChar = str.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                if (charFrequency.get(leftChar) == 0) {
                    charFrequency.remove(leftChar);
                }
                left++;  
            }
            if (charFrequency.size() == k && right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left; 
            }
            right++;  
        }

        return maxLength == 0 ? "" : str.substring(start, start + maxLength);
    }
}
