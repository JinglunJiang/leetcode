class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0, new ArrayList<>());
        return result;
    }

    public void backtracking(int[] nums, int index, List<Integer> list){
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++){
            if (i != index && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);
            backtracking(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}