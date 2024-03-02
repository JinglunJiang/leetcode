class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1){
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] <= intervals[i - 1][1]){
                intervals[i][0] = Math.min(intervals[i - 1][0], intervals[i][0]);
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
            }
            else{
                list.add(intervals[i - 1]);
            }
        }
        list.add(intervals[intervals.length - 1]);
        return list.toArray(new int[list.size()][2]);
    }
}