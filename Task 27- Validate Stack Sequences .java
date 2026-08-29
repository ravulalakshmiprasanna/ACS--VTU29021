import java.util.Stack;

class Solution27 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0; // Pointer for the popped array
        
        for (int val : pushed) {
            stack.push(val); // Push the current element
            
            // Check if the top of the stack matches the next element to pop
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++; // Move to the next element in popped
            }
        }
        
        // If all elements were successfully matched and popped, the stack will be empty
        return stack.isEmpty();
    }
}
