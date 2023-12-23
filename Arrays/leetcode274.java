class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[citations.length - i - 1] >= i + 1) {
                return i + 1;
            }
        }
        return 0;
    }
}