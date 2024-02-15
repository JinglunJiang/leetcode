class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                if (mat[i][j] == 0){
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
                else{
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int column = current[1];
            int distance = result[row][column] + 1;

            for (int[] direction : directions){
                int i = row + direction[0];
                int j = column + direction[1];
                if (i >= 0 && j >= 0 && i < mat.length && j < mat[0].length){
                    if (result[i][j] > distance){
                        result[i][j] = distance;
                        queue.offer(new int[]{i, j});
                    }
                }
            }
        }
        return result;
    }
}