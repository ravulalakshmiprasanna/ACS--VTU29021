import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution29 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0; // Result index
        
        // Deque will store indices of elements
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window boundary
            if (!q.isEmpty() && q.peekFirst() == i - k) {
                q.pollFirst();
            }
            
            // 2. Remove elements smaller than the current element from the back
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            
            // 3. Add the current element's index to the back
            q.offerLast(i);
            
            // 4. If the window has reached size k, append the max to the result
            if (i >= k - 1) {
                result[ri++] = nums[q.peekFirst()];
            }
        }
        
        return result;
    }
}

/**
 * Boilerplate execution class to test the Sliding Window Maximum.
 */
public class Main {
    public static void main(String[] args) {
        Solution29 solver = new Solution29();

        // Test Case 1
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] res1 = solver.maxSlidingWindow(nums1, k1);
        System.out.println("Test Case 1 Result: " + Arrays.toString(res1));
        // Expected Output: [3, 3, 5, 5, 6, 7]

        // Test Case 2
        int[] nums2 = {1};
        int k2 = 1;
        int[] res2 = solver.maxSlidingWindow(nums2, k2);
        System.out.println("Test Case 2 Result: " + Arrays.toString(res2));
        // Expected Output: [1]
    }
}
