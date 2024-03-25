class KthLargest {
    PriorityQueue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums){
            add(num);
        }
    }
    
    public int add(int val) {
        if (queue.size() < k){
            queue.offer(val);
        }
        else{
            if (val > queue.peek()){
                queue.poll();
                queue.offer(val);
            }
        }
        return queue.peek();
    }
}