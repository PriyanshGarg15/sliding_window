



//sliding window technique
import java.util.LinkedList;
import java.util.Queue;

public class a2_first_negative_integer_in_every_window_of_size_k {

    public static void findFirstNegativeInWindow(int[] arr, int k) {
        Queue<Integer> negatives = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                negatives.add(i);
            }
        }
        if (!negatives.isEmpty()) {
            System.out.print(arr[negatives.peek()] + " ");
        } else {
            System.out.print("0 ");
        }
        for (int i = 1; i <= arr.length - k; i++) {
            if (!negatives.isEmpty() && negatives.peek() < i) {
                negatives.poll();
            }
            if (arr[i + k - 1] < 0) {
                negatives.add(i + k - 1);
            }
            if (!negatives.isEmpty()) {
                System.out.print(arr[negatives.peek()] + " ");
            } else {
                System.out.print("0 ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, 7, 8, 15, 30, 16, 28};
        int k = 3;
        findFirstNegativeInWindow(arr, k);
    }
}
