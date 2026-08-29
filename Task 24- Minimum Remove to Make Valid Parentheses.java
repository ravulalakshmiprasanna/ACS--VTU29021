import java.util.Stack;

class Solution24 {
    public String minRemoveToMakeValid(String s) {
        // Stack to store the indices of opening brackets '('
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i); // Save index of the open bracket
            } else if (arr[i] == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // Found a valid pair, remove from stack
                } else {
                    arr[i] = '*'; // Mark unmatched closing bracket for removal
                }
            }
        }
        
        // Any indices left in the stack are unmatched opening brackets '('
        while (!stack.isEmpty()) {
            arr[stack.pop()] = '*'; // Mark unmatched opening bracket for removal
        }
        
        // Rebuild the final string skipping all marked '*' positions
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
