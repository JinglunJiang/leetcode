class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        int maxPosition = 0;
        for (int[] trip : trips){
            maxPosition = Math.max(maxPosition, trip[2]);
        }
        int[] stops = new int[maxPosition + 1];
        for (int[] trip : trips){
            int numOfPassenger = trip[0];
            int start = trip[1];
            int stop = trip[2];

            stops[start] += numOfPassenger;
            stops[stop] -= numOfPassenger;
        }

        int current = 0;
        for (int i = 0; i <= maxPosition; i++){
            current += stops[i];
            if (current > capacity){
                return false;
            }
        }
        return true;
    }
}