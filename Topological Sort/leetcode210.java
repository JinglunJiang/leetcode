class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
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
                result.add(i);
            }
        }
        while (!queue.isEmpty()){
            int current = queue.poll();
            for (int course : list.get(current)){
                inDegree[course]--;
                if (inDegree[course] == 0){
                    queue.offer(course);
                    result.add(course);
                    count++;
                }
            }
        }
        if (count != numCourses){
            return new int[]{};
        }
        int[] finall = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            finall[i] = result.get(i);
        }
        return finall;
    }
}