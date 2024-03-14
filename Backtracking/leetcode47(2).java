class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, new ArrayList<>(), visited);
        return result;
    }

    public void backtracking(int[] nums, ArrayList<Integer> list, boolean[] visited){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
                continue;
            }
            if (!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                backtracking(nums, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}