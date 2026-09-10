import java.util.*;

class Solution {
    private static class Tuple {
        TreeNode node;
        int row;
        int col;
        
        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> finalResult = new ArrayList<>();
        if (root == null) {
            return finalResult;
        }

        // TreeMap keeps columns sorted automatically from smallest to largest
        // Inside each column, we group by row using another TreeMap
        // Inside each row, we use a PriorityQueue to automatically keep duplicate positions sorted by node value
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        // Queue for level order traversal (BFS)
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;

            if (!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }
            if (!map.get(col).containsKey(row)) {
                map.get(col).put(row, new PriorityQueue<>());
            }
            map.get(col).get(row).offer(node.val);

            if (node.left != null) {
                queue.offer(new Tuple(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }
        for (TreeMap<Integer, PriorityQueue<Integer>> columns : map.values()) {
            List<Integer> currentColumn = new ArrayList<>();
            for (PriorityQueue<Integer> nodesInRow : columns.values()) {
                while (!nodesInRow.isEmpty()) {
                    currentColumn.add(nodesInRow.poll());
                }
            }
            finalResult.add(currentColumn);
        }

        return finalResult;
    }
}
