class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, visited, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] nums, boolean[] visited, List<Integer> list){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
                continue;
            }
            if (visited[i]){
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtracking(nums, visited, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}