class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i, boolean[] visited){
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++){
            if (!visited[j] && isConnected[i][j] == 1){
                dfs(isConnected, j, visited);
            }
        }
    }
}