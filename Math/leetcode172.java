class Solution {
    public int trailingZeroes(int n) {
        int twos = 0;
        int fives = 0;
        for (int i = 1; i <= n; i++) {
            int current = i;
            while (current % 5 == 0) {
                current /= 5;
                fives++;
            }
            while (current % 2 == 0) {
                current /= 2;
                twos++;
            }
        }
        return Math.min(twos, fives);
    }
}