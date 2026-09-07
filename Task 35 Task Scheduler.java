import java.util.Arrays;

// ==========================================
// Copy ONLY the Solution class to LeetCode
// ==========================================
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task (A-Z)
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }

        // Step 2: Sort frequencies to easily find the maximum frequencies
        Arrays.sort(frequencies);

        // The maximum frequency will be at the last index
        int maxFreq = frequencies[25];

        // Step 3: Count how many tasks share this maximum frequency
        int maxFreqCount = 0;
        for (int i = 25; i >= 0; i--) {
            if (frequencies[i] == maxFreq) {
                maxFreqCount++;
            } else {
                break; // Frequencies are sorted, so we can stop early
            }
        }

        // Step 4: Calculate slots using the structural greedy formula
        int chunks = maxFreq - 1;
        int chunkLength = n + 1;
        int minIntervalsNeeded = (chunks * chunkLength) + maxFreqCount;

        // Step 5: Handle edge case where total tasks exceed calculated formula slots
        return Math.max(minIntervalsNeeded, tasks.length);
    }
}

// ==========================================
// Driver Class for local execution
// ==========================================
public class Solution35 {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Example 1
        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n1 = 2;
        System.out.println("Example 1 Output: " + solver.leastInterval(tasks1, n1)); // Expected: 8

        // Test Example 2
        char[] tasks2 = {'A', 'C', 'A', 'B', 'D', 'B'};
        int n2 = 1;
        System.out.println("Example 2 Output: " + solver.leastInterval(tasks2, n2)); // Expected: 6
    }
}
