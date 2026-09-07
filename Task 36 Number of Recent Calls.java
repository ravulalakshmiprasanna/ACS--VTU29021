import java.util.LinkedList;
import java.util.Queue;


class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }
    
    public int ping(int t) {
        requests.add(t);
        
        // Remove requests outside the [t - 3000, t] window
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }
        
        return requests.size();
    }
}


public class Solution36 {
    public static void main(String[] args) {
        // Instantiate the counter as LeetCode does behind the scenes
        RecentCounter recentCounter = new RecentCounter();
        
        // Simulating the Example 1 testcase
        System.out.println(recentCounter.ping(1));    // Output: 1 (Window: [-2999, 1], requests:)
        System.out.println(recentCounter.ping(100));  // Output: 2 (Window: [-2900, 100], requests:)
        System.out.println(recentCounter.ping(3001)); // Output: 3 (Window:, requests:)
        System.out.println(recentCounter.ping(3002)); // Output: 3 (Window:, requests:, 1 is removed)
    }
}
