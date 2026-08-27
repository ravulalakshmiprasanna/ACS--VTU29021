import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the next greater element for each number in nums2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        // Stack to maintain a monotonic decreasing order of elements
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 to find the next greater element for all its numbers
        for (int num : nums2) {
            // While stack is not empty and current number is greater than stack's top
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num); // Push current element onto the stack
        }

        // Remaining elements in stack have no greater element to their right
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }

        // Build the result array for nums1 using our precomputed map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}
