package sash_coding;

public class a4_lc_209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0; 
        int ans = Integer.MAX_VALUE; 
        int left = 0; 

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1); 
                sum -= nums[left];
                left++;
            }
        }
        //if no such subarray is possible than we had to return 0 not the Integer.MAX_VALUE
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }

    public static void main(String[] args) {
        a4_lc_209_Minimum_Size_Subarray_Sum solution = new a4_lc_209_Minimum_Size_Subarray_Sum();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3})); // Output: 2
        System.out.println(solution.minSubArrayLen(4, new int[]{1, 4, 4}));         // Output: 1
        System.out.println(solution.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1})); // Output: 0
    }
}
