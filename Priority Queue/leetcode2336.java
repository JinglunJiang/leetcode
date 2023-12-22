class SmallestInfiniteSet {
    Set<Integer> set;
    PriorityQueue<Integer> queue;

    public SmallestInfiniteSet() {
        set = new HashSet<>();
        queue = new PriorityQueue<>();
        for (int i = 1; i <= 1000; i++){
            set.add(i);
            queue.offer(i);
        }
    }
    
    public int popSmallest() {
        int result = queue.peek();
        set.remove(result);
        return queue.poll();
    }
    
    public void addBack(int num) {
        if (!set.contains(num)){
            queue.offer(num);
            set.add(num);
        }
        return;
    }
}