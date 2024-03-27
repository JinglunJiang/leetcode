class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0, new ArrayList<>());
        return result;
    }

    public void backtracking(int[] nums, int index, ArrayList<Integer> list){
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++){
            list.add(nums[i]);
            backtracking(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}