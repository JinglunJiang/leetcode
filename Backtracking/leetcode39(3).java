class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }

    public void backtracking(int[] candidates, int target, int current, int index, ArrayList<Integer> list){
        if (current == target){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++){
            if (current + candidates[i] <= target){
                list.add(candidates[i]);
                backtracking(candidates, target, current + candidates[i], i, list);
                list.remove(list.size() - 1);
            }
        }
    }
}