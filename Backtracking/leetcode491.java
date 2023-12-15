class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] nums, int index, List<Integer> list){
        if (list.size() >= 2){
            result.add(new ArrayList<>(list));
        }
        if (index == nums.length){
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++){
            if (used.contains(nums[i])){
                continue;
            }
            if (list.size() == 0 || nums[i] >= list.get(list.size() - 1)){
                list.add(nums[i]);
                backtracking(nums, i + 1, list);
                list.remove(list.size() - 1);
                used.add(nums[i]);
            }
        }
    }
}