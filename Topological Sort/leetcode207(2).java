class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            list.add(i, new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int pre = prerequisite[1];
            list.get(pre).add(course);
            inDegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++){
            if (inDegree[i] == 0){
                queue.offer(i);
                count++;
            }
        }
        while (!queue.isEmpty()){
            int current = queue.poll();
            for (int course : list.get(current)){
                inDegree[course]--;
                if (inDegree[course] == 0){
                    queue.offer(course);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}