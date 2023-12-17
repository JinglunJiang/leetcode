class Solution {
    public int reverse(int x) {
        Queue<Integer> queue = new LinkedList<>();
        boolean isnegative = false;
        if (x < 0){
            isnegative = true;
            x = -x;
        }
        while (x > 0){
            int num = x % 10;
            queue.offer(num);
            x = x / 10;
        }
        int result = 0;
        while (!queue.isEmpty()){
            int digit = queue.poll();
            if (result > (Integer.MAX_VALUE - digit) / 10){
                return 0;
            } // check before updating the value;
            result = result * 10 + digit;
        }
        if (isnegative){
            result = -result;
        }
        return result;
    }
}