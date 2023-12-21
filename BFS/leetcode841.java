class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] opened = new boolean[rooms.size()];
        for (int i = 0; i < opened.length; i++){
            opened[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()){
            int current = queue.poll();
            opened[current] = true;
            List<Integer> keys = rooms.get(current);
            for (int key : keys){
                if (!opened[key]){
                    queue.offer(key);
                }
            }
        }
        for (int i = 0; i < rooms.size(); i++){
            if (opened[i] == false){
                return false;
            }
        }
        return true;
    }
}