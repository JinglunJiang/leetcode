/*
This problem needs to start from the points that is 0 in order to avoid TLE
push all those 0 points into the queue, and the distance starts from 1
check if the point check result == -1
increment the distance
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int distance = 1;
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
                else{
                    result[i][j] = -1;
                }
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] current = queue.poll();
                int row = current[0];
                int column = current[1];
                for (int[] direction : directions){
                    int newrow = row + direction[0];
                    int newcolumn = column + direction[1];
                    if (newrow >= 0 && newrow < mat.length && newcolumn >= 0 && newcolumn < mat[0].length && result[newrow][newcolumn] == -1){
                        result[newrow][newcolumn] = distance;
                        queue.add(new int[]{newrow, newcolumn});
                    }
                }
            }
            distance++;
        }
        return result;
    }
}