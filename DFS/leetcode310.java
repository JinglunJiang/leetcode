class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<Set<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency.add(new HashSet<>());
        }

        int[] degree = new int[n];

        for (int[] edge : edges) {
            adjacency.get(edge[0]).add(edge[1]);
            adjacency.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                leaves.offer(i);
            }
        }

        while (n > 2) {
            int size = leaves.size();
            n -= size;

            for (int i = 0; i < size; i++) {
                int current = leaves.poll();
                for (int neighbor : adjacency.get(current)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>(leaves);
        return result;
    }
}