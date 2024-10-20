
import java.util.*;

public class a9_max_consecutive_ones_3_leetcode_1004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {0, 1, 1, 0, 0, 1, 1};
        int k = sc.nextInt();
        int max = pattern(arr, k);
        System.out.println(max);
    }

    public static int pattern(int[] arr, int k) {
        int start = 0;
        int max = 0; 
        int countZero = 0;

        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 0) { 
                countZero++;
            }

            while (countZero > k) {
                if (arr[start] == 0) {  
                    countZero--;
                }
                start++;
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
