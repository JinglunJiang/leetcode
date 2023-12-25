class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<List<Integer>> pacific = new ArrayList<>();
    List<List<Integer>> atlantic = new ArrayList<>();
    boolean[][] visitedPacific;
    boolean[][] visitedAtlantic;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        visitedPacific = new boolean[heights.length][heights[0].length];
        visitedAtlantic = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++){
            for (int j = 0; j < heights[0].length; j++){
                if (i == 0 || j == 0){
                    visitedPacific[i][j] = true;
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    pacific.add(list);
                    Pacific(heights, i, j);
                }
                if (i == heights.length - 1 || j == heights[0].length - 1){
                    visitedAtlantic[i][j] = true;
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    atlantic.add(list);
                    Atlantic(heights, i, j);
                }
            }
        }
        for (List<Integer> listp : pacific){
            if (atlantic.contains(listp) && !result.contains(listp)){
                result.add(listp);
            }
        }
        return result;
    }

    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public void Pacific(int[][] heights, int i, int j){
        for (int[] direction : directions){
            int row = i + direction[0];
            int column = j + direction[1];
            if (row >= 0 && column >= 0 && row < heights.length && column < heights[0].length && heights[row][column] >= heights[i][j] && !visitedPacific[row][column]){
                visitedPacific[row][column] = true;
                List<Integer> list = new ArrayList<>();
                list.add(row);
                list.add(column);
                pacific.add(list);
                Pacific(heights, row, column);
            }
        }
    }

    public void Atlantic(int[][] heights, int i, int j){
        for (int[] direction : directions){
        int row = i + direction[0];
        int column = j + direction[1];
        if (row >= 0 && column >= 0 && row < heights.length && column < heights[0].length && heights[row][column] >= heights[i][j] && !visitedAtlantic[row][column]){
                visitedAtlantic[row][column] = true;
                List<Integer> list = new ArrayList<>();
                list.add(row);
                list.add(column);
                atlantic.add(list);
                Atlantic(heights, row, column);
            }
        }
    }
}