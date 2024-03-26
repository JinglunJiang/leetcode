class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones){
            queue.offer(stone);
        }
        while (queue.size() > 1){
            int first = queue.poll();
            int second = queue.poll();
            if (first == second){
                continue;
            }
            else{
                queue.offer(Math.abs(first - second));
            }
        }
        if (queue.size() == 0){
            return 0;
        }
        return queue.poll();
    }
}