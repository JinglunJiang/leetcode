class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks){
            count[task - 'A']++;
        }
        int maxQuantity = 0;
        for (int i = 0; i < 26; i++){
            if (count[i] > maxQuantity){
                maxQuantity = count[i];
            }
        }
        int maxNumber = 0;
        for (int i = 0; i < count.length; i++){
            if (count[i] == maxQuantity){
                maxNumber++;
            }
        }
        return Math.max(tasks.length, (n + 1) * (maxQuantity - 1) + maxNumber);
    }
}