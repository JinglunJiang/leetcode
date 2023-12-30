class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) ->{
            if (a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        LinkedList<int[]> result = new LinkedList<>();
        for (int[] p : people){
            result.add(p[1], p);
        }
        return result.toArray(new int[people.length][2]);
    }
}