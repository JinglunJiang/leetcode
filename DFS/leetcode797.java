class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, list);
        return result;
    }

    public void dfs(int[][] graph, List<Integer> path){
        if (path.get(path.size() - 1) == graph.length - 1){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i : graph[path.get(path.size() - 1)]){
            path.add(i);
            dfs(graph, path);
            path.remove(path.size() - 1);
        }
    }
}