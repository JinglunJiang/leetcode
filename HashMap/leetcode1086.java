class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] item : items){
            if (!map.containsKey(item[0])){
                map.put(item[0], new ArrayList<>());
            }
            map.get(item[0]).add(item[1]);
        }
        int[][] result = new int[map.size()][2];
        int y = 0;
        for (int key : map.keySet()){
            List<Integer> list = map.get(key);
            Collections.sort(list, Collections.reverseOrder());
            int sum = 0;
            for (int i = 0; i < 5; i++){
                sum += list.get(i);
            }
            int average = sum / 5;
            result[y][0] = key;
            result[y][1] = average;
            y++;
        }
        Arrays.sort(result, Comparator.comparingInt(a -> a[0]));
        return result;
    }
}