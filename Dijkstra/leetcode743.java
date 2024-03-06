class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for (int[] time : times){
            list.get(time[0] - 1).add(new int[]{time[1] - 1, time[2]});
        }
        int[] t = new int[n];
        Arrays.fill(t, Integer.MAX_VALUE);
        t[k - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k - 1, 0});
        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int node = current[0];
            int time = current[1];
            for (int[] neighbor : list.get(node)){
                if (t[node] + neighbor[1] < t[neighbor[0]]){
                    t[neighbor[0]] = t[node] + neighbor[1];
                    pq.offer(new int[]{neighbor[0], t[neighbor[0]]});
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++){
            max = Math.max(t[i], max);
        }
        if (max == Integer.MAX_VALUE){
            return -1;
        }
        return max;
    }
}