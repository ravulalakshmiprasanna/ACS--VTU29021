import java.util.Stack;

class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shiftStacks();
        return popStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        shiftStacks();
        return popStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    /** Helper method to move elements from pushStack to popStack when needed. */
    private void shiftStacks() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }
}

/**
 * Boilerplate execution class to test the MyQueue implementation.
 */
public class Solution28 {
    public static void main(String[] args) {
        // 1. Initialize the queue
        MyQueue queue = new MyQueue();
        System.out.println("Queue initialized.");

        // 2. Test push operations
        System.out.println("\n--- Testing Push ---");
        queue.push(10);
        System.out.println("Pushed: 10");
        queue.push(20);
        System.out.println("Pushed: 20");
        queue.push(30);
        System.out.println("Pushed: 30");

        // 3. Test peek operation
        System.out.println("\n--- Testing Peek ---");
        System.out.println("Front element (peek): " + queue.peek()); // Expected: 10

        // 4. Test pop operations
        System.out.println("\n--- Testing Pop ---");
        System.out.println("Popped: " + queue.pop()); // Expected: 10
        System.out.println("Popped: " + queue.pop()); // Expected: 20

        // 5. Test interweaving push and pop
        System.out.println("\n--- Testing Interleaved Operations ---");
        queue.push(40);
        System.out.println("Pushed: 40");
        System.out.println("Front element (peek): " + queue.peek()); // Expected: 30
        System.out.println("Popped: " + queue.pop()); // Expected: 30
        System.out.println("Popped: " + queue.pop()); // Expected: 40

        // 6. Test empty check
        System.out.println("\n--- Testing Empty Check ---");
        System.out.println("Is queue empty? " + queue.empty()); // Expected: true
    }
}
