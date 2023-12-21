class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        List<Integer> list = new ArrayList<>();
        for (int[] point : points){
            list.add(point[0]);
        }
        Collections.sort(list);
        int max = 0;
        for (int i = 1; i < list.size(); i++){
            int distance = list.get(i) - list.get(i - 1);
            max = Math.max(distance, max);
        }
        return max;
    }
}