class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] result = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                if (mat[i][j] == 0){
                    queue.offer(new int[]{i, j});
                    result[i][j] = 0;
                }
                else{
                    result[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            for (int[] direction : directions){
                int row = direction[0] + current[0];
                int column = direction[1] + current[1];
                int distance = result[current[0]][current[1]];
                if (row >= 0 && row < mat.length && column >= 0 && column < mat[0].length && result[row][column] == -1){
                    result[row][column] = distance + 1;
                    queue.offer(new int[]{row, column});
                }
            }
        }
        return result;
    }
}