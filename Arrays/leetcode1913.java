class Solution {
    public int maxProductDifference(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums){
            queue.offer(num);
        }
        int x = queue.poll();
        int y = queue.poll();
        while (queue.size() > 2){
            queue.poll();
        }
        int w = queue.poll();
        int z = queue.poll();
        return w * z - x * y;
    }
}