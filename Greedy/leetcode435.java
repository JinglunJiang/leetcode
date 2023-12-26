class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        int pointer = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] >= pointer){
                pointer = intervals[i][1];
            }
            else{
                if (pointer > intervals[i][1]){
                    pointer = intervals[i][1];
                }
                count++;
            }
        }
        return count;
    }
}