class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (color == image[sr][sc]){
            return image;
        }
        int start = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, color, visited, start);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, boolean[][] visited, int start){
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visited[sr][sc] || image[sr][sc] != start){
            return;
        }
        image[sr][sc] = color;
        visited[sr][sc] = true;
        for (int[] direction : directions){
            int row = sr + direction[0];
            int column = sc + direction[1];
            dfs(image, row, column, color, visited, start);
        }
    }