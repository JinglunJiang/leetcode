class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int j = cardPoints.length - 1;
        while (k > 0){
            sum += cardPoints[j];
            j--;
            k--;
        }
        j++;
        int max = sum;
        int i = 0;
        while (j <= cardPoints.length - 1){
            sum -= cardPoints[j];
            sum += cardPoints[i];
            max = Math.max(sum, max);
            i++;
            j++;
        }
        return max;
    }
}