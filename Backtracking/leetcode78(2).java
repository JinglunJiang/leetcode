class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(0, nums, new ArrayList<>());
        return result;
    }

    private void backtracking(int index, int[] nums, List<Integer> list){
        result.add(new ArrayList<>(list));
        if (index == nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            list.add(nums[i]);
            backtracking(i + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }
}