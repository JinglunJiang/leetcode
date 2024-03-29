public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++){
            count += mask & n;
            n >>= 1;
        }
        return count;
    }
}