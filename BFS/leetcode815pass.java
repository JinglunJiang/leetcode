//Hash the routes instead of the stops to make it more efficient
//The hashmap is <Stop, Routes> -> later can get the stops in a route by the index
//No need to revertly find the value in the Hashmap
//Because the route is in sequence as for the index
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();

        for (int routeIndex = 0; routeIndex < routes.length; routeIndex++) {
            for (int stop : routes[routeIndex]) {
                stopToRoutes.putIfAbsent(stop, new ArrayList<>());
                stopToRoutes.get(stop).add(routeIndex);
            }
        }

        Set<Integer> visitedRoutes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int current = queue.poll();
                if (current == target){
                    return level;
                }
                if (stopToRoutes.containsKey(current)){
                    for (int route : stopToRoutes.get(current)){
                        if (!visitedRoutes.contains(route)){
                            visitedRoutes.add(route);
                            for (int stop : routes[route]){
                                queue.offer(stop);
                            }
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}