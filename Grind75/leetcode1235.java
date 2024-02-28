class Solution {
    class Job{
        int start;
        int end;
        int profit;
        Job(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> a.end - b.end);
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        for (int i = 1; i < n; i++){
            int currentProfitIncluded = jobs[i].profit;
            int index = findLastIndex(jobs, i);
            if (index != -1){
                currentProfitIncluded += dp[index];
            }
            dp[i] = Math.max(dp[i - 1], currentProfitIncluded);
        }
        return dp[n - 1];
    }

    public int findLastIndex(Job[] jobs, int index){
        int low = 0;
        int high = index - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (jobs[mid].end <= jobs[index].start){
                if (mid == high || jobs[mid + 1].end > jobs[index].start){
                    return mid;
                }
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}