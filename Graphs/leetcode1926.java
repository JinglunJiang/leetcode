class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        Set<int[]> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        int steps = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] current = queue.poll();
                if (current[0] == 0 || current[0] == maze.length - 1 || current[1] == 0 || current[1] == maze[0].length - 1){
                    if (current[0] != entrance[0] || current[1] != entrance[1]){
                        return steps;
                    }
                }
                for (int[] direction : directions){
                    int row = current[0] + direction[0];
                    int column = current[1] + direction[1];
                    if (row >= 0 && row < maze.length && column >= 0 && column < maze[0].length && maze[row][column] == '.'){
                        queue.offer(new int[]{row, column});
                        maze[row][column] = '+';
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}