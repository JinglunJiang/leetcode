class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (tx < sx || ty < sy){
            return false;
        }
        int[] start = {sx, sy};
        Queue<int[]> queue = new LinkedList<>();
        Set<int[]> set = new HashSet<>();
        queue.offer(start);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                if ((x + y == tx && y == ty) || (x == tx && x + y == ty)){
                    return true;
                }
                int[] first = {x + y, y};
                int[] second = {x, x + y};
                if (!set.contains(first) && x + y <= tx){
                    set.add(first);
                    queue.offer(first);
                }
                if (!set.contains(second) && x + y <= ty){
                    set.add(second);
                    queue.offer(second);
                }
            }
        }
        return false;
    }
}