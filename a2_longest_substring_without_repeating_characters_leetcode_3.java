import java.util.HashSet;
import java.util.Scanner;

public class a2_longest_substring_without_repeating_characters_leetcode_3 
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int ans=lengthOfLongestSubstring(s);
        System.out.println(ans);
    }
    public static int lengthOfLongestSubstring(String s) 
    {
        HashSet<Character> h = new HashSet<>();
        int ans = 0;
        int start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            while (h.contains(s.charAt(end))) 
            {
                h.remove(s.charAt(start));
                start++;
            }
            h.add(s.charAt(end));
            ans = Math.max(ans, end - start + 1);
        }
        
        return ans;
    }
}
