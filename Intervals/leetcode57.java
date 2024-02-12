class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals){
            if (interval[1] < newInterval[0] || interval[0] > newInterval[1]){
                result.add(interval);
            }
            else{
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        result.add(newInterval);
        Collections.sort(result, (a, b) -> a[0] - b[0]);
        return result.toArray(new int[result.size()][2]);
    }
}