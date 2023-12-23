class Solution {
    public boolean isPathCrossing(String path) {
        Set<List<Integer>> set = new HashSet<>();
        int x = 0;
        int y = 0;
        set.add(Arrays.asList(0, 0));
        for (char c : path.toCharArray()){
            if (c == 'N'){
                y++;
            }
            if (c == 'S'){
                y--;
            }
            if (c == 'E'){
                x++;
            }
            if (c == 'W'){
                x--;
            }
            if (set.contains(Arrays.asList(x, y))){
                return true;
            }else{
                set.add(Arrays.asList(x, y));
            }
        }
        return false;
    }
}