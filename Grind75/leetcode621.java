class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0){
            return tasks.length;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int[] frequencies = new int[26];
        for (char task : tasks){
            frequencies[task - 'A']++;
        }
        for (int i = 0; i < 26; i++){
            if (frequencies[i] != 0){
                pq.offer(frequencies[i]);
            }
        }
        int time = 0;
        while (!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if (!pq.isEmpty()){
                int current = pq.poll() - 1;
                if (current > 0){
                    queue.offer(new Pair(current, time + n));
                }
            }
            if (!queue.isEmpty() && queue.peek().getValue() == time){
                pq.offer(queue.poll().getKey());
            }
        }
        return time;
    }
}