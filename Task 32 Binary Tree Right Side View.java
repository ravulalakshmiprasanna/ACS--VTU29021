import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 1. Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) { 
        this.val = val; 
    }
}

// 2. Primary Class matching your file name "Solution32.java"
public class Solution32 {
    
    // LeetCode core method
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                // If it's the last node of the current level, it is visible from the right side
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }
                
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        
        return result;
    }

    // 3. Main execution method to test locally
    public static void main(String[] args) {
        Solution32 solution = new Solution32();

        // Constructing Tree Example 1: [1, 2, 3, null, 5, null, 4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // Execute and print output
        List<Integer> visibleNodes = solution.rightSideView(root);
        System.out.println("Right Side View Output: " + visibleNodes); 
    }
}
