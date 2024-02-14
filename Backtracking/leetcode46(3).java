class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list= new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        backtracking(nums, list, set);
        return result;
    }

    private void backtracking(int[] nums, ArrayList<Integer> list, Set<Integer> set){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!set.contains(nums[i])){
                list.add(nums[i]);
                set.add(nums[i]);
                backtracking(nums, list, set);
                set.remove(nums[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}