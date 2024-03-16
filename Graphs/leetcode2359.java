class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] distance1 = new int[edges.length];
        int[] distance2 = new int[edges.length];

        Arrays.fill(distance1, Integer.MAX_VALUE);
        Arrays.fill(distance2, Integer.MAX_VALUE);

        calculateDistances(edges, node1, distance1);
        calculateDistances(edges, node2, distance2);

        int result = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++){
            int maxDistance = Math.max(distance1[i], distance2[i]);
            if (maxDistance < minDistance){
                minDistance = maxDistance;
                result = i;
            }
        }
        return result;
    }

    public void calculateDistances(int[] edges, int node1, int[] distance){
        int dist = 0;
        for (int current = node1; current != -1 && distance[current] == Integer.MAX_VALUE; current = edges[current]){
            distance[current] = dist++;
        }
    }
}