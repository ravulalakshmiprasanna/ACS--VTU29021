import java.util.Stack;

class Solution22 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone(); // Clone the original array to modify it in place
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of item indices

        for (int i = 0; i < n; i++) {
            // While stack is not empty and current price is less than or equal to
            // the price of the item at the index stored on top of the stack
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = prices[prevIndex] - prices[i]; // Apply the discount
            }
            // Push the current index onto the stack
            stack.push(i);
        }

        return result;
    }
}
