

//     public static int maxSumSubarrayOfSizeK(int[] arr, int k) {
//         int maxSum = Integer.MIN_VALUE;
//         for (int i = 0; i <= arr.length - k; i++) {
//             int currentSum = 0;
//             for (int j = i; j < i + k; j++) {
//                 currentSum += arr[j];
//             }
//             maxSum = Math.max(maxSum, currentSum);
//         }

//         return maxSum;
//     }

//     public static void main(String[] args) {
//         int[] arr = {2, 1, 5, 1, 3, 2};
//         int k = 3;
//         int result = maxSumSubarrayOfSizeK(arr, k);
//         System.out.println("Maximum sum of subarray of size " + k + " is: " + result);
//     }
// }


//using sliding window approach:-

public class a1_max_sum_subarray_of_size_k 
{
    public static int maxSumSubarrayOfSizeK(int[] arr, int k) 
    {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;
        for (int i = 1; i <= arr.length - k; i++) 
        {
            windowSum = windowSum - arr[i - 1] + arr[i + k - 1];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int result = maxSumSubarrayOfSizeK(arr, k);
        System.out.println("Maximum sum of subarray of size " + k + " is: " + result);
    }
}
