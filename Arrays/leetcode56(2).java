class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] <= intervals[i - 1][1]){
                intervals[i][0] = Math.min(intervals[i][0], intervals[i - 1][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            }
            else{
                result.add(intervals[i - 1]);
            }
        }
        result.add(intervals[intervals.length - 1]);
        int[][] finalResult = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++){
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
}