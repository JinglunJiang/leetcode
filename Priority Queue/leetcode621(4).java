class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int max = 0;
        for (char task : map.keySet()){
            if (map.get(task) > max){
                max = map.get(task);
            }
        }
        int maxCount = 0;
        for (char task : map.keySet()){
            if (map.get(task) == max){
                maxCount++;
            }
        }
        return Math.max(tasks.length, (n + 1) * (max - 1) + maxCount);
    }
}