import java.util.*;

class Solution {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        // Give ungrouped items their own groups
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        // Group -> items
        List<List<Integer>> groupItems = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            groupItems.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            groupItems.get(group[i]).add(i);
        }

        // Item graph and group graph
        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }

        int[] itemDegree = new int[n];
        int[] groupDegree = new int[m];

        // Build graphs
        for (int i = 0; i < n; i++) {

            for (int before : beforeItems.get(i)) {

                itemGraph.get(before).add(i);
                itemDegree[i]++;

                // Different groups
                if (group[before] != group[i]) {
                    groupGraph.get(group[before]).add(group[i]);
                    groupDegree[group[i]]++;
                }
            }
        }

        // Sort groups
        List<Integer> sortedGroups = topoSort(groupGraph, groupDegree);

        if (sortedGroups.size() != m) {
            return new int[0];
        }

        List<Integer> answer = new ArrayList<>();

        // Sort items inside each group
        for (int g : sortedGroups) {

            List<Integer> items = groupItems.get(g);

            List<Integer> sortedItems =
                topoSortItems(items, itemGraph, itemDegree);

            if (sortedItems.size() != items.size()) {
                return new int[0];
            }

            answer.addAll(sortedItems);
        }

        // Convert List to int[]
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    // Topological sort for groups
    private List<Integer> topoSort(
            List<List<Integer>> graph,
            int[] degree) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for (int next : graph.get(current)) {
                degree[next]--;

                if (degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return result;
    }

    // Topological sort for items of one group
    private List<Integer> topoSortItems(
            List<Integer> items,
            List<List<Integer>> graph,
            int[] degree) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        Set<Integer> itemSet = new HashSet<>(items);

        for (int item : items) {
            if (degree[item] == 0) {
                queue.offer(item);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for (int next : graph.get(current)) {

                if (!itemSet.contains(next)) {
                    continue;
                }

                degree[next]--;

                if (degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return result;
    }
}