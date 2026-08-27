import java.util.Stack;

class Solution20 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        // Stack to store indices of the temperatures array
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the current temperature is warmer
            // than the temperature at the index stored at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                // The number of days to wait is the difference between indices
                answer[prevIndex] = i - prevIndex;
            }
            // Push the current index onto the stack
            stack.push(i);
        }

        // Remaining indices in the stack automatically keep their default value of 0
        return answer;
    }
}

