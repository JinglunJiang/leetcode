class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int level = 0;
        queue.offer(n);
        set.add(n);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int current = queue.poll();
                if (current == 0){
                    return level;
                }
                for (int j = 1; j * j <= current; j++){
                    int next = current - j * j;
                    if (!set.contains(next)){
                        queue.offer(next);
                        set.add(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}