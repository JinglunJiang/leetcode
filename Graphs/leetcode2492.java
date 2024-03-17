class Solution {
    int score = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        for (int[] road : roads){
            list.get(road[0]).add(new int[]{road[1], road[2]});
            list.get(road[1]).add(new int[]{road[0], road[2]});
        }
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        dfs(list, visited, 1);
        return score;
    }

    public void dfs(List<List<int[]>> list, boolean[] visited, int current){
        visited[current] = true;
        for (int[] neighbor : list.get(current)){
            score = Math.min(neighbor[1], score);
            if (!visited[neighbor[0]]){
                dfs(list, visited, neighbor[0]);
            }
        }
    }
}