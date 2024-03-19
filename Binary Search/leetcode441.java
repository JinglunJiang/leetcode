class Solution {
    public int arrangeCoins(int n) {
        int i = 0;
        int j = n;
        while (i <= j){
            double mid = i + (j - i) / 2;
            if (mid * (mid + 1) / 2 > n){
                j = (int) mid - 1;
            }
            else if (mid * (mid + 1) / 2 < n){
                i = (int) mid + 1;
            }
            else{
                return (int) mid;
            }
        }
        return j;
    }
}