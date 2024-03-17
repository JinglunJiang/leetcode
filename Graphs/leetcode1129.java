class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> list1 = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();

        for (int i = 0; i < n; i++){
            list1.add(new ArrayList<>());
            list2.add(new ArrayList<>());
        }

        for (int[] edge : redEdges){
            list1.get(edge[0]).add(edge[1]);
        }

        for (int[] edge : blueEdges){
            list2.get(edge[0]).add(edge[1]);
        }

        int[] result = new int[n];
        boolean[][] visited = new boolean[n][2];
        Arrays.fill(result, -1);
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        visited[0][1] = true;
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        result[0] = 0;

        int distance = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] current = queue.poll();
                int node = current[0];
                int color = current[1];
                List<List<Integer>> currentList = color == 0 ? list2 : list1;
                for (int next : currentList.get(node)){
                    if (!visited[next][1 - color]){
                        queue.offer(new int[]{next, 1 - color});
                        if (result[next] == -1){
                            result[next] = distance + 1;
                        }
                        visited[next][1 - color] = true;
                    }
                }
            }
            distance++;
        }
        return result;
    }
}