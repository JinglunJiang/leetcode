class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        return dfs(list, 0, -1, hasApple);
    }

    public int dfs(List<List<Integer>> list, int current, int parent, List<Boolean> hasApple){
        int time = 0;
        for (int neighbor : list.get(current)){
            if (neighbor != parent){
                int subTreeTime = dfs(list, neighbor, current, hasApple);
                if (hasApple.get(neighbor) || subTreeTime > 0){
                    time += 2;
                    time += subTreeTime;
                }
            }
        }
        return time;
    }
}