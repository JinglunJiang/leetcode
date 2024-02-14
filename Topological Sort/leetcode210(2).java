class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        boolean visited[] = new boolean[numCourses];
        boolean path[] = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites){
            list.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++){
            if (!visited[i]){
                if (!dfs(i, list, visited, path, stack)){
                    return new int[0];
                }
            }
        }
        int i = 0;
        while (!stack.isEmpty()){
            result[i++] = stack.pop();
        }
        return result;
    }

    private boolean dfs(int i, List<List<Integer>> list, boolean[] visited, boolean[] path, Stack<Integer> stack){
        visited[i] = true;
        path[i] = true;
        for (int course : list.get(i)){
            if (!visited[course]){
                if (!dfs(course, list, visited, path, stack)){
                    return false;
                }
            }
            else if (path[course]){
                return false;
            }
        }
        path[i] = false;
        stack.push(i);
        return true;
    }
}