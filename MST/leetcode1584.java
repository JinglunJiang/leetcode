class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points.length == 1){
            return 0;
        }
        int n = points.length;
        boolean[] inMST = new boolean[n];
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        int totalCost = 0;
        for (int count = 0; count < n; count++){
            int u = -1;
            for (int i = 0; i < n; i++){
                if (!inMST[i] && (u == -1 || cost[i] < cost[u])){
                    u = i;
                }
            }
            inMST[u] = true;
            totalCost += cost[u];

            for (int v = 0; v < n; v++){
                if(!inMST[v]){
                    int weight = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    if (cost[v] > weight){
                        cost[v] = weight;
                    }
                }
            }
        }
        return totalCost;
    }
}