class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums){
            queue.offer(num);
        }
        while (k > 1){
            queue.poll();
            k--;
        }
        return queue.peek();
    }
}