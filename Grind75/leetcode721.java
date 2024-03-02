class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> account : accounts){
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++){
                String email = account.get(i);
                emailToName.put(email, name);
                graph.computeIfAbsent(email, x -> new ArrayList<>());

                if (i == 1){
                    continue;
                }

                String prevEmail = account.get(i - 1);
                graph.get(prevEmail).add(email);
                graph.get(email).add(prevEmail);
            }
        }


        Set<String> visited = new HashSet<>();
        List<List<String>> mergedAccounts = new ArrayList<>();

        for (String email : graph.keySet()){
            if (!visited.contains(email)){
                List<String> emails = new ArrayList<>();
                dfs(email, emails, graph, visited);
                Collections.sort(emails);
                emails.add(0, emailToName.get(email));
                mergedAccounts.add(emails);
            }
        }
        return mergedAccounts;
    }

    private void dfs(String email, List<String> emails, Map<String, List<String>> graph, Set<String> visited){
        if (visited.contains(email)){
            return;
        }
        emails.add(email);
        visited.add(email);
        for (String next : graph.get(email)){
            dfs(next, emails, graph, visited);
        }
    }
}