class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, new ArrayList<>(), used);
        return result;
    }

    private void backtracking(int[] nums, List<Integer> list, boolean[] used){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (used[i]){
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backtracking(nums, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}