class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++){
            result[i] = count(i);
        }
        return result;
    }

    public int count(int n){
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++){
            count += mask & n;
            n >>= 1;
        }
        return count;
    }
}