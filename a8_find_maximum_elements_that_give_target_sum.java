
import java.util.*;
public class a8_find_maximum_elements_that_give_target_sum {
    public static void main(String[] args) {
        int[] arr = {5,10,2,1,18};
        int targetSum = 18;
        int result = findMaxSlidingWindow(arr, targetSum);
        System.out.println(result); //4 becz of  5,10,2,1 has 4 elements that can give us our target !!
    }

    public static int findMaxSlidingWindow(int[] nums, int targetSum) {
        int start = 0;
        int windowSum = 0;
        int maxLength = 0;
        for (int end = 0; end < nums.length; end++) {
            windowSum += nums[end];
            
            while (windowSum > targetSum && start <= end) {
                windowSum -= nums[start];
                start++;
            }

            if (windowSum == targetSum && (end - start + 1) > maxLength) {
                maxLength = end - start + 1;
            }
        }
        return maxLength;
    }
}
