// cannot store in a map if you use bfs (you need the sequence)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] degree = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites){
            list.get(prerequisite[1]).add(prerequisite[0]);
            degree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++){
            if (degree[i] == 0){
                queue.offer(i);
                count++;
            }
        }
        while(!queue.isEmpty()){
            int current = queue.poll();
            for (int j : list.get(current)){
                degree[j]--;
                if (degree[j] == 0){
                    queue.offer(j);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}