class Solution {
    public int mySqrt(int x) {
        int i = 1;
        int j = x;
        while (i <= j){
            long mid = i + (j - i) / 2;
            if (mid * mid > x){
                j = (int) mid - 1;
            }
            else if (mid * mid < x){
                i = (int) mid + 1;
            }
            else {
                return (int) mid;
            }
        }
        return j;
    }
}