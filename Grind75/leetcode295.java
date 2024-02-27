class MedianFinder {
    PriorityQueue<Integer> largeQueue = new PriorityQueue<>();
    PriorityQueue<Integer> smallQueue = new PriorityQueue<>((a, b) -> b - a);

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        smallQueue.offer(num);
        // Balance the largest number from the smaller half to the larger half
        largeQueue.offer(smallQueue.poll());

        // If the large half is larger than the small half, move one element back to small half
        if (largeQueue.size() > smallQueue.size()) {
            smallQueue.offer(largeQueue.poll());
        }
    }
    
    public double findMedian() {
        if (smallQueue.size() > largeQueue.size()){
            return smallQueue.peek();
        }
        if (largeQueue.size() > smallQueue.size()){
            return largeQueue.peek();
        }
        return (double)(smallQueue.peek() + largeQueue.peek()) / 2;
    }
}