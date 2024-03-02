class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        backtracking(nums, set, list);
        return result;
    }

    public void backtracking(int[] nums, Set<Integer> set, List<Integer> list){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!set.contains(nums[i])){
                list.add(nums[i]);
                set.add(nums[i]);
                backtracking(nums, set, list);
                list.remove(list.size() - 1);
                set.remove(nums[i]);
            }
        }
    }
}