class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()){
            queue.offer(num);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = queue.poll();
        }
        return result;
    }
}