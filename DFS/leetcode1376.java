class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        for (int i = 0; i < n; i++){
            map.put(manager[i], map.getOrDefault(manager[i], new ArrayList<>()));
            map.get(manager[i]).add(i);
        }
        return inform(headID, informTime);
    }

    public int inform(int headID, int[] informTime){
        List<Integer> subordinates = map.get(headID);
        if (subordinates == null || subordinates.isEmpty()){
            return 0;
        }
        int result = 0;
        for (int subordinate : subordinates){
            result = Math.max(result, inform(subordinate, informTime));
        }
        return result + informTime[headID];
    }
}