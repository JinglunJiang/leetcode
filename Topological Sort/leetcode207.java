class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites){
            if (!map.containsKey(prerequisite[0])){
                map.put(prerequisite[0], new ArrayList<>());
            }
            map.get(prerequisite[0]).add(prerequisite[1]);
        }
        Set<Integer> processed = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++){
            if (!visited.contains(i)){
                if (!dfs(i, visited, map, processed)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int i, Set<Integer> visited, Map<Integer, List<Integer>> map, Set<Integer> processed){
        if (processed.contains(i)){
            return true;
        }
        if (visited.contains(i)){
            return false;
        }
        if (map.get(i) == null){
            return true;
        }
        visited.add(i);
        for (int prerequisite : map.get(i)){
            if (visited.contains(prerequisite)){
                return false;
            }
            if (!dfs(prerequisite, visited, map, processed)){
                return false;
            }
        }
        visited.remove(i);
        processed.add(i);
        return true;
    }
}