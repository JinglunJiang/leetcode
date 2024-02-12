class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0;i < isConnected.length; i++){
            if (!set.contains(i)){
                dfs(isConnected, i, set);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, int i, Set<Integer> set){
        set.add(i);
        for (int j = 0; j < isConnected.length; j++){
            if (isConnected[i][j] == 1 && !set.contains(j)){
                dfs(isConnected, j, set);
            }
        }
    }
}