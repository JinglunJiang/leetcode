class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        // Step 1: Create adjacency list and degree array
        List<Set<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency.add(new HashSet<>());
        }
        int[] degree = new int[n];

        // Step 2: Populate adjacency list and degree array
        for (int[] edge : edges) {
            adjacency.get(edge[0]).add(edge[1]);
            adjacency.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        // Step 3: Initialize leaves queue with initial leaves
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                leaves.offer(i);
            }
        }

        // Step 4: Iteratively remove leaves until 1 or 2 nodes are left
        while (n > 2) {
            int size = leaves.size();
            n -= size;

            for (int i = 0; i < size; i++) {
                int current = leaves.poll();

                // Remove current leaf and update degrees
                for (int neighbor : adjacency.get(current)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

        // Step 5: Remaining nodes in the queue are roots of minimum height trees
        List<Integer> result = new ArrayList<>(leaves);
        return result;
    }
}
