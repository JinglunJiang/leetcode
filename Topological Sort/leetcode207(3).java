class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        for (int[] prerequisite : prerequisites){
            list.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++){
            if (inDegree[i] == 0){
                queue.offer(i);
                count++;
            }
        }

        while (!queue.isEmpty()){
            int current = queue.poll();
            for (int neighbor : list.get(current)){
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0){
                    count++;
                    queue.offer(neighbor);
                }
            }
        }
        return count == numCourses;
    }
}