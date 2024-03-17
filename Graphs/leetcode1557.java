class Solution {
    Set<Integer> result = new HashSet<>();
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges){
            list.get(edge.get(1)).add(edge.get(0));
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(list, i, visited);
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i : result){
            answer.add(i);
        }
        return answer;
    }

    public void dfs(List<List<Integer>> list, int current, boolean[] visited){
        visited[current] = true;
        if (list.get(current).size() == 0){
            result.add(current);
        }
        for (int root : list.get(current)){
            if (!visited[root]){
                visited[root] = true;
                dfs(list, root, visited);
            }
        }
    }
}