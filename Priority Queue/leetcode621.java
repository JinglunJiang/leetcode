class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0){
            return tasks.length;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int[] array = new int[26];
        for (char task : tasks){
            array[task - 'A']++;
        }
        for (int i : array){
            if (i > 0){
                maxHeap.add(i);
            }
        }
        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if (!maxHeap.isEmpty()){
                int value = maxHeap.poll();
                value--;
                if (value > 0){
                    queue.add(new Pair(value, time + n));
                }
            }
            if (!queue.isEmpty() && queue.peek().getValue() == time){
                maxHeap.add(queue.poll().getKey());
            }
        }
        return time;
    }
}