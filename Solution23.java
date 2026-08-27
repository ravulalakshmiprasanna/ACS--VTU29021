import java.util.Stack;

class Solution23 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Loop through each character in the string
        for (char c : s.toCharArray()) {
            // Option 1: If it's an opening bracket, push its matching closing bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // Option 2: If it's a closing bracket, check if it matches the top of the stack
            else {
                // If stack is empty or the top doesn't match the closing bracket, it's invalid
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}
