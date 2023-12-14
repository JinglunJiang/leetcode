class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums){
        backtracking(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] nums, int index, List<Integer> list){
        if (index >= nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        backtracking(nums, index + 1, list);
        list.remove(list.size() - 1);
        backtracking(nums, index + 1, list);
    }
}