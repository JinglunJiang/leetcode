class Solution {
    long result;
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= roads.length; i++){
            list.add(new ArrayList<>());
        }
        for (int[] road : roads){
            list.get(road[0]).add(road[1]);
            list.get(road[1]).add(road[0]);
        }
        boolean[] visited = new boolean[roads.length + 1];
        dfs(list, 0, seats, visited);
        return result;
    }

    public int dfs(List<List<Integer>> list, int city, int seats, boolean[] visited){
        int people = 1;
        visited[city] = true;
        for (int neighbor : list.get(city)){
            if (!visited[neighbor]){
                people += dfs(list, neighbor, seats, visited);
            }
        }
        if (city != 0){
            result += (int) Math.ceil((double) people / seats);
        }
        return people;
    }
}