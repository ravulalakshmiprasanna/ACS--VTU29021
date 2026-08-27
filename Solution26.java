import java.util.Stack;

class Solution27 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            boolean alive = true;
            
            // Collision happens ONLY if stack top is moving right (+) and current is moving left (-)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                // If the top asteroid is smaller, it explodes. Keep checking the rest of the stack.
                if (stack.peek() < Math.abs(ast)) {
                    stack.pop();
                    continue; 
                } 
                // If both are the same size, they both explode.
                else if (stack.peek() == Math.abs(ast)) {
                    stack.pop();
                }
                // If the top asteroid is larger, the current incoming asteroid explodes.
                alive = false;
                break;
            }
            
            // If the incoming asteroid survived all collisions, push it to the stack
            if (alive) {
                stack.push(ast);
            }
        }
        
        // Convert the stack back into an array to return the result
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
