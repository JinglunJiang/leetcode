class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++){
            list.add(new ArrayList<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        int[] outDegree = new int[graph.length];
        for (int i = 0; i < graph.length; i++){
            for (int dest : graph[i]){
                list.get(dest).add(i);
            }
            outDegree[i] += graph[i].length;
        }

        for (int i = 0; i < graph.length; i++){
            if (outDegree[i] == 0){
                queue.offer(i);
                result.add(i);
            }
        }

        while(!queue.isEmpty()){
            int current = queue.poll();
            for (int neighbor : list.get(current)){
                outDegree[neighbor]--;
                if (outDegree[neighbor] == 0){
                    result.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}