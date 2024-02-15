class Solution {
    List<Boolean> result = new ArrayList<>();
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites){
            list.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int[] query : queries){
            Set<Integer> set = new HashSet<>();
            boolean canReach = dfs(query[0], query[1], list, set);
            result.add(canReach);
        }
        return result;
    }

    private boolean dfs(int i, int j, List<List<Integer>> list, Set<Integer> set){
        if (i == j){
            return true;
        }
        set.add(i);
        for (int current : list.get(i)){
            if (!set.contains(current) && dfs(current, j, list, set)){
                return true;
            }
        }
        return false;
    }
}