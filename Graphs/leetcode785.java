class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++){
            color[i] = 0;
            if (!dfs(graph, color, i)){
                return false;
            }
            Arrays.fill(color, -1);
        }
        return true;
    }

    public boolean dfs(int[][] graph, int[] color, int current){
        for (int neighbor : graph[current]){
            if (color[neighbor] != -1){
                if (color[neighbor] == color[current]){
                    return false;
                }
            }
            else{
                color[neighbor] = 1 - color[current];
                if (!dfs(graph, color, neighbor)){
                    return false;
                }
            }
        }
        return true;
    }
}