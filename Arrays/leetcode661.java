class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < img.length; i++){
            for (int j = 0; j < img[0].length; j++){
                result[i][j] = calculate(img, i, j);
            }
        }
        return result;
    }

    public int calculate(int[][] img, int x, int y){
        int count = 0;
        int total = 0;
        List<int[]> directions = Arrays.asList(
            new int[]{-1, -1}, 
            new int[]{-1, 0}, 
            new int[]{0, -1}, 
            new int[]{0, 1}, 
            new int[]{1, 0}, 
            new int[]{1, 1}, 
            new int[]{0, 0}, 
            new int[]{-1, 1}, 
            new int[]{1, -1}
        );
        for (int[] direction : directions){
            int dx = direction[0];
            int dy = direction[1];
            if (x + dx >= 0 && x + dx < img.length && y + dy >= 0 && y + dy < img[0].length){
                count++;
                total += img[x + dx][y + dy];
            }
        }
        return total / count;
    }
}