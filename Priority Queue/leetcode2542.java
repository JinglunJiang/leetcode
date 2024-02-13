class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pair = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++){
            pair[i][0] = nums2[i];
            pair[i][1] = nums1[i];
        }
        Arrays.sort(pair, (a, b) -> b[0] - a[0]);
        long result = 0;
        long currentSum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++){
            currentSum += pair[i][1];
            queue.offer(pair[i][1]);
            if (queue.size() > k){
                currentSum -= queue.poll();
            }
            if (queue.size() == k){
                result = Math.max(currentSum * pair[i][0], result);
            }
        }
        return result;
    }
}