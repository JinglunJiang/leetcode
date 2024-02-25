class Solution {
    public int reverse(int x) {
        Queue<Integer> queue = new LinkedList<>();
        boolean isNegative = false;
        if (x < 0){
            isNegative = true;
            x = -x;
        }
        while (x > 0){
            queue.offer(x % 10);
            x /= 10;
        }
        int result = 0;
        while (!queue.isEmpty()){
            int digit = queue.poll();
            if (result > (Integer.MAX_VALUE - digit) / 10){
                return 0;
            }
            result = result * 10 + digit;
        }
        if (isNegative){
            result = -result;
        }
        return result;
    }
}