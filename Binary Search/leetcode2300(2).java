class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++){
            int j = 0;
            int k = potions.length - 1;
            while (j <= k){
                int mid = j + (k - j) / 2;
                if (potions[mid] * (long)spells[i] >= success){
                    k = mid - 1;
                }
                else{
                    j = mid + 1;
                }
                result[i] = potions.length - j;
            }
        }
        return result;
    }
}