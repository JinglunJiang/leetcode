class Solution {
    int count = 0;
    Set<Integer> set = new HashSet<>();
    List<List<Integer>> list = new ArrayList<>();

    public int minReorder(int n, int[][] connections) {
        for (int i = 0; i < n; i++){
            list.add(i, new ArrayList<>());
        }

        for (int[] connection : connections){
            list.get(connection[0]).add(connection[1]);
            list.get(connection[1]).add(-connection[0]);
        }
        dfs(0);
        return count;
    }

    public void dfs(int start){
        set.add(start);
        for (int neighbor : list.get(start)){
            int abs = Math.abs(neighbor);
            if (!set.contains(abs)){
                if (neighbor > 0){
                    count++;
                }
                dfs(abs);
            }
        }
    }
}