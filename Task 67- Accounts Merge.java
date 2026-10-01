import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> name = new HashMap<>();

        // Build graph
        for (List<String> account : accounts) {
            String person = account.get(0);
            String firstEmail = account.get(1);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);

                graph.putIfAbsent(email, new ArrayList<>());
                name.put(email, person);

                if (i > 1) {
                    graph.get(firstEmail).add(email);
                    graph.get(email).add(firstEmail);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        // DFS for every email
        for (String email : graph.keySet()) {

            if (visited.contains(email)) {
                continue;
            }

            List<String> emails = new ArrayList<>();
            dfs(email, graph, visited, emails);

            Collections.sort(emails);

            List<String> account = new ArrayList<>();
            account.add(name.get(email));
            account.addAll(emails);

            result.add(account);
        }

        return result;
    }

    private void dfs(String email,
                     Map<String, List<String>> graph,
                     Set<String> visited,
                     List<String> emails) {

        visited.add(email);
        emails.add(email);

        for (String next : graph.get(email)) {
            if (!visited.contains(next)) {
                dfs(next, graph, visited, emails);
            }
        }
    }
}