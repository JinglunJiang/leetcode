class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight : weights){
            left = Math.max(left, weight);
            right += weight;
        }
        left = Math.max(left, (right / days));
        int result = right;
        while (left <= right){
            int capacity = left + (right - left) / 2;
            if (canShip(weights, days, capacity)){
                result = Math.min(result, capacity);
                right = capacity - 1;
            }
            else{
                left = capacity + 1;
            }
        }
        return result;
    }

    public boolean canShip(int[] weights, int days, int capacity){
        int currentCapacity = capacity;
        int ships = 1;
        for (int weight : weights){
            if (currentCapacity - weight < 0){
                ships += 1;
                currentCapacity = capacity;
            }
            currentCapacity -= weight;
        }
        return ships <= days;
    }
}