class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (char key : map.keySet()){
            if (map.get(key) != 0){
                pq.offer(map.get(key));
            }
        }
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int time = 0;
        while (!queue.isEmpty() || !pq.isEmpty()){
            time++;
            if (!pq.isEmpty()){
                int current = pq.poll();
                if (current - 1 > 0){
                    queue.offer(new Pair(current - 1, time + n));
                }
            }
            if (!queue.isEmpty()){
                if (queue.peek().getValue() == time){
                    pq.offer(queue.poll().getKey());
                }
            }
        }
        return time;
    }
}