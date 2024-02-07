class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long s = 1;
        long e = (long) Math.pow(10, 10);
        long m1 = 0, m2 = 0, m3 = 0;
        while (s < e){
            long mid = (s + e) / 2;
            m1 = mid - mid / divisor1;
            m2 = mid - mid / divisor2;
            m3 = mid - mid / lcm(divisor1, divisor2);
            if (m1 >= uniqueCnt1 && m2 >= uniqueCnt2 && m3 >= uniqueCnt1 + uniqueCnt2){
                e = mid;
            }
            else{
                s = mid + 1;
            }
        }
        return (int)s;
    }

    private long gcd(long n1, long n2){
        if (n1 == 0){
            return n2;
        }
        if (n2 == 0){
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    private long lcm(long n1, long n2){
        return n1 * n2 / gcd(n1, n2);
    }
}