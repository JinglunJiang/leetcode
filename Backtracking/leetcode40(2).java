class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        backtracking(candidates, 0, target, 0, new ArrayList<>(), visited);
        return result;
    }

    public void backtracking(int[] candidates, int index, int target, int current, ArrayList<Integer> list, boolean[] visited){
        if (current == target){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++){
            if (i != index && candidates[i] == candidates[i - 1] && !visited[i - 1]){
                continue;
            }
            if (candidates[i] + current <= target && !visited[i]){
                visited[i] = true;
                list.add(candidates[i]);
                backtracking(candidates, i + 1, target, current + candidates[i], list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}