class Solution {
    List<List<Integer>> map = new ArrayList<>();

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        for (int i = 0; i < n; i++){
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++){
            if (manager[i] != -1){
                map.get(manager[i]).add(i);
            }
        }
        return inform(headID, informTime);
    }

    public int inform(int headID, int[] informTime){
        List<Integer> surbordinates = map.get(headID);
        if (surbordinates.size() == 0){
            return 0;
        }
        int result = 0;
        for (int surbordinate : surbordinates){
            result = Math.max(inform(surbordinate, informTime), result);
        }
        return result + informTime[headID];
    }
}