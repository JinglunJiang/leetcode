class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        if (n == 1){
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        for (int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){
            if (inDegree[i] == 1){
                queue.offer(i);
            }
        }
        while (n > 2){
            int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++){
                int current = queue.poll();
                for (int neighbor : list.get(current)){
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 1){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return new ArrayList<>(queue);
    }
}