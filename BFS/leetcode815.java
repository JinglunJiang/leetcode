class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++){
            for (int j = 0; j < routes[i].length; j++){
                if (!map.containsKey(routes[i][j])){
                    map.put(routes[i][j], new ArrayList<>());
                }
                for (int k = 0; k < routes[i].length; k++){
                    if (routes[i][j] != routes[i][k]){
                        map.get(routes[i][j]).add(routes[i][k]);
                    }
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        Set<Integer> set = new HashSet<>();
        set.add(source);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int current = queue.poll();
                if (current == target){
                    return level;
                }
                for (int stop : map.get(current)){
                    if (!set.contains(stop)){
                        queue.offer(stop);
                        set.add(stop);
                    }
                }
                set.add(current);
            }
            level++;
        }
        return -1;
    }
}