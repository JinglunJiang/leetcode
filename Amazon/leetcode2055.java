class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        TreeMap<Integer, Integer> map = new TreeMap<>(); // index, presum
        
        int sum = 0;
        for (int i = 0; i < n; i++){
            if (s.charAt(i) == '*'){
                sum++;
            }
            else{
                map.put(i, sum);
            }
        }

        int m = queries.length;
        int[] res = new int[m];

        for (int i = 0; i < m; i++){
            int start = queries[i][0], end = queries[i][1];
            Integer left = map.ceilingKey(start);
            Integer right = map.floorKey(end);
            if (left != null && right != null && left < right){
                res[i] = map.get(right) - map.get(left);
            }
        }
        return result;
    }
}