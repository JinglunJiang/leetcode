class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] dictionary = new int[26];
        for (char task : tasks){
            dictionary[task - 'A']++;
        }
        int maxFrequency = 0;
        for (int i = 0; i < 26; i++){
            if (dictionary[i] > maxFrequency){
                maxFrequency = dictionary[i];
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++){
            if (dictionary[i] == maxFrequency){
                count++;
            }
        }
        return Math.max(tasks.length, (maxFrequency - 1) * (n + 1) + count);
    }
}