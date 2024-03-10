class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        long quotient = 0;
        while (lDividend >= lDivisor){
            long tempDivisor = lDivisor, multiple = 1;
            while (lDividend >= (tempDivisor << 1)){
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            lDividend -= tempDivisor;
            quotient += multiple;
        }
        if (isNegative){
            quotient = -quotient;
        }
        return (int) quotient;
    }
}