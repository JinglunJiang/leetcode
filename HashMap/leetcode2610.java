class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (!map.isEmpty()){
            List<Integer> list = new ArrayList<>();
            List<Integer> toBeRemoved = new ArrayList<>();
            for (int num : map.keySet()){
                list.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0){
                    toBeRemoved.add(num);
                }
            }
            for (int num : toBeRemoved){
                map.remove(num);
            }
            result.add(list);
        }
        return result;
    }
}