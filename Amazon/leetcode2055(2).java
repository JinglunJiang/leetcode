class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        TreeMap<Integer, Integer> treemap = new TreeMap<>(); // index, count
        
        int prefixSum = 0;

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '*'){
                prefixSum++;
            }
            else{
                treemap.put(i, prefixSum);
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];

            Integer low = treemap.ceilingKey(start);
            Integer high = treemap.floorKey(end);

            if (low != null && high != null && high > low){
                result[i] = treemap.get(high) - treemap.get(low);
            }
        }
        return result;
    }
}