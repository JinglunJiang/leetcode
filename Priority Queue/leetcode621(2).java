class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks){
            map[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++){
            if (map[i] != 0){
                pq.offer(map[i]);
            }
        }
        int time = 0;
        while (!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if (!pq.isEmpty()){
                int current = pq.poll();
                if (current - 1 > 0){
                    queue.offer(new Pair(current - 1, time + n));
                }
            }
            if (!queue.isEmpty() && queue.peek().getValue() == time){
                pq.offer(queue.poll().getKey());
            }
        }
        return time;
    }
}