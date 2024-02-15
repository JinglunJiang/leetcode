class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> 
            (Math.abs(a[0]) * Math.abs(a[0]) + Math.abs(a[1]) * Math.abs(a[1])) - 
            (Math.abs(b[0]) * Math.abs(b[0]) + Math.abs(b[1]) * Math.abs(b[1]))
        );
        for (int[] point : points){
            queue.offer(point);
        }
        for (int i = 0; i < k; i++){
            int[] current = queue.poll();
            result[i][0] = current[0];
            result[i][1] = current[1];
        }
        return result;
    }
}