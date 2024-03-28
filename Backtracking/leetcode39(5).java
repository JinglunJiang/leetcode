class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }

    public void backtracking(int[] candidates, int target, List<Integer> list, int current, int index){
        if (current == target){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++){
            if (candidates[i] + current <= target){
                list.add(candidates[i]);
                backtracking(candidates, target, list, current + candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }
}