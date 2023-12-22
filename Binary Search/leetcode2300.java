class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < n; i++){
            int j = 0;
            int k = m - 1;
            while (j <= k){
                int mid = j + (k - j) / 2;
                if ((long)spells[i] * potions[mid] >= success){
                    k = mid - 1;
                }
                else if ((long)spells[i] * potions[mid] < success){
                    j = mid + 1;
                }
            }
            result[i] = m - j;
        }
        return result;
    }
}