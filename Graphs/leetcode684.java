class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++){
            parent[i] = i;
        }
        for (int[] edge : edges){
            if (find(edge[0]) == find(edge[1])){
                return edge;
            }
            else{
                union(edge[0], edge[1]);
            }
        }
        return new int[2];
    }

    public int find(int a){
        if (parent[a] == a){
            return a;
        }
        return find(parent[a]);
    }

    public void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        parent[parentA] = parentB;
    }
}