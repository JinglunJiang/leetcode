class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] nums, List<Integer> list){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backtracking(nums, list);
            list.remove(list.size() - 1);
        }
    }
}