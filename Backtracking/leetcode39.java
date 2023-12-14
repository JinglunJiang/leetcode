class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(0, candidates, target, new ArrayList<>());
        return result;
    }

    public void backtracking(int start, int[] candidates, int target, List<Integer> list){
        if (target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++){
            if (target - candidates[i] >= 0){
                if (list.isEmpty() || candidates[i] >= list.get(list.size() - 1)){
                    list.add(candidates[i]);
                    backtracking(start, candidates, target - candidates[i], list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}