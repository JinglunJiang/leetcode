class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites){
            list.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        int index = 0;
        for (int i = 0; i < numCourses; i++){
            if (inDegree[i] == 0){
                result[index++] = i;
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int course = queue.poll();
            for (int neighbor : list.get(course)){
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                    result[index++] = neighbor;
                }
            }
        }
        if (index != numCourses){
            return new int[0];
        }
        return result;
    }
}