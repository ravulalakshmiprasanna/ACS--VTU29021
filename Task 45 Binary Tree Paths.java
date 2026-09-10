import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            searchPaths(root, "", result);
        }
        return result;
    }
    private void searchPaths(TreeNode node, String path, List<String> result) {
        if (node.left == null && node.right == null) {
            result.add(path + node.val);
            return;
        }
        if (node.left != null) {
            searchPaths(node.left, path + node.val + "->", result);
        }
        if (node.right != null) {
            searchPaths(node.right, path + node.val + "->", result);
        }
    }
}
