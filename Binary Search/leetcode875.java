class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long i = 1;
        long j = 0;
        for (int pile : piles){
            j += pile;
        }
        long result = j;
        while (i < j){
            long mid = i + (j - i) / 2;
            if (canFinish(mid, h, piles)){
                result = Math.min(result, mid);
                j = mid;
            }
            else{
                i = mid + 1;
            }
        }
        return (int) result;
    }

    public boolean canFinish(long amount, int h, int[] piles){
        int time = 0;
        for (int pile : piles){
            time += pile / amount;
            if (pile % amount != 0){
                time++;
            }
        }
        return time <= h;
    }
}