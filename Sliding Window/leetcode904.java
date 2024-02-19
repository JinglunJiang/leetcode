class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2){
            return fruits.length;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int i = 0;
        int result = 2;
        for (int j = 0; j < fruits.length; j++){
            if (!map.containsKey(fruits[j])){
                map.put(fruits[j], new ArrayList<>());
            }
            map.get(fruits[j]).add(j);
            while (map.keySet().size() > 2){
                List<Integer> list = map.get(fruits[i]);
                list.remove(list.indexOf(i));
                if (list.isEmpty()){
                    map.remove(fruits[i]);
                }
                i++;
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}