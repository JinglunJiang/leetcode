class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1];
        dfs(n, new ArrayList<>(), used);
        return count;
    }

    public void dfs(int n, List<Integer> list, boolean[] used){
        if (list.size() == n){
            count++;
            return;
        }
        for (int i = 1; i <= n; i++){
            if (used[i]){
                continue;
            }
            if ((list.size() + 1) % i != 0 && i % (list.size() + 1) != 0){
                continue;
            }
            used[i] = true;
            list.add(i);
            dfs(n, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
    // public boolean isBeautiful(List<Integer> list){
    //     for (int i = 0; i < list.size(); i++){
    //         if (list.get(i) % (i + 1) != 0 && (i + 1) % list.get(i) != 0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}