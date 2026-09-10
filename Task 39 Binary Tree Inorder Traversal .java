import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        // Base case: if the node is empty, turn back
        if (node == null) {
            return;
        }

        // 1. Traverse the left subtree
        helper(node.left, result);

        // 2. Visit the current root node
        result.add(node.val);

        // 3. Traverse the right subtree
        helper(node.right, result);
    }
}
