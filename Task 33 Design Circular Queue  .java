import java.util.Arrays;

// Primary Class matching your local filename "Solution32.java"
public class Solution33 {

    // 1. Core Circular Queue Implementation (Static class so it can be called inside main)
    static class MyCircularQueue {
        private int[] queue;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        // Initializes the object with the size of the queue to be k.
        public MyCircularQueue(int k) {
            this.capacity = k;
            this.queue = new int[k];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }
        
        // Inserts an element into the circular queue. Return true if the operation is successful.
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            // Move rear pointer circularly forward
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            return true;
        }
        
        // Deletes an element from the circular queue. Return true if the operation is successful.
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            // Move front pointer circularly forward
            front = (front + 1) % capacity;
            size--;
            return true;
        }
        
        // Gets the front item from the queue. If the queue is empty, return -1.
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[front];
        }
        
        // Gets the last item from the queue. If the queue is empty, return -1.
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return queue[rear];
        }
        
        // Checks whether the circular queue is empty or not.
        public boolean isEmpty() {
            return size == 0;
        }
        
        // Checks whether the circular queue is full or not.
        public boolean isFull() {
            return size == capacity;
        }
    }

    // 2. Local Boilerplate Execution Framework to get clean terminal output
    public static void main(String[] args) {
        System.out.println("--- Testing MyCircularQueue (LeetCode 622) ---");
        
        // Initialize queue with capacity k = 3
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        
        System.out.println("enQueue(1): " + myCircularQueue.enQueue(1)); // Expected: true
        System.out.println("enQueue(2): " + myCircularQueue.enQueue(2)); // Expected: true
        System.out.println("enQueue(3): " + myCircularQueue.enQueue(3)); // Expected: true
        System.out.println("enQueue(4): " + myCircularQueue.enQueue(4)); // Expected: false (Queue full)
        
        System.out.println("Rear(): " + myCircularQueue.Rear());         // Expected: 3
        System.out.println("isFull(): " + myCircularQueue.isFull());     // Expected: true
        
        System.out.println("deQueue(): " + myCircularQueue.deQueue());   // Expected: true
        System.out.println("enQueue(4): " + myCircularQueue.enQueue(4)); // Expected: true
        System.out.println("Rear(): " + myCircularQueue.Rear());         // Expected: 4
        System.out.println("Front(): " + myCircularQueue.Front());       // Expected: 2 (since 1 was deQueued)
    }
}
