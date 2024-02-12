class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int count = 0;
        for (int task : map.keySet()){
            int num = map.get(task);
            while (num >= 2){
                if (num % 3 == 0){
                    count += num / 3;
                    num = 0;
                    break;
                }
                num -= 2;
                count++;
            }
            if (num != 0){
                return -1;
            }
        }
        return count;
    }
}