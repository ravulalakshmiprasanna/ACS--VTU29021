import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(
            int n, int[][] redEdges, int[][] blueEdges) {

        List<Integer>[][] graph = new ArrayList[2][n];

        for (int color = 0; color < 2; color++) {
            for (int i = 0; i < n; i++) {
                graph[color][i] = new ArrayList<>();
            }
        }

        // 0 = red, 1 = blue
        for (int[] edge : redEdges) {
            graph[0][edge[0]].add(edge[1]);
        }

        for (int[] edge : blueEdges) {
            graph[1][edge[0]].add(edge[1]);
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        answer[0] = 0;

        // [node, lastColor]
        Queue<int[]> queue = new LinkedList<>();

        // Start with both colors possible
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});

        boolean[][] visited = new boolean[2][n];
        visited[0][0] = true;
        visited[1][0] = true;

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                int node = current[0];
                int lastColor = current[1];

                // Next color must be opposite
                int nextColor = 1 - lastColor;

                for (int next : graph[nextColor][node]) {

                    if (!visited[nextColor][next]) {

                        visited[nextColor][next] = true;
                        queue.offer(new int[]{next, nextColor});

                        if (answer[next] == -1) {
                            answer[next] = distance + 1;
                        }
                    }
                }
            }

            distance++;
        }

        return answer;
    }
}