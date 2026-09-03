import java.util.ArrayDeque;
import java.util.Deque;

class Solution30{
    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Deques to maintain max and min tracking indices
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // Maintain decreasing order in maxDeque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Maintain increasing order in minDeque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // Shrink the window from the left if the condition is violated
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++; // Shrink window
            }

            // Update the maximum length of a valid window found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

/**
 * Boilerplate execution class to test the Solution.
 */
public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        int[] nums1 = {8, 2, 4, 7};
        int limit1 = 4;
        System.out.println("Test Case 1 Result: " + solver.longestSubarray(nums1, limit1)); // Expected: 2

        // Test Case 2
        int[] nums2 = {10, 1, 2, 4, 7, 2};
        int limit2 = 5;
        System.out.println("Test Case 2 Result: " + solver.longestSubarray(nums2, limit2)); // Expected: 4

        // Test Case 3
        int[] nums3 = {4, 2, 2, 2, 4, 4, 2, 2};
        int limit3 = 0;
        System.out.println("Test Case 3 Result: " + solver.longestSubarray(nums3, limit3)); // Expected: 3
    }
}
