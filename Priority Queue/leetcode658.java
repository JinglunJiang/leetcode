class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (Math.abs(x - a) == Math.abs(x - b)){
                return a - b;
            }
            else{
                return Math.abs(x - a) - Math.abs(x - b);
            }});
        for (int i = 0; i < arr.length; i++){
            queue.offer(arr[i]);
        }
        for (int i = 0; i < k; i++){
            result.add(queue.poll());
        }
        Collections.sort(result);
        return result;
    }
}