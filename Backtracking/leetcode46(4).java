class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, 0, new ArrayList<>(), visited);
        return result;
    }

    public void backtracking(int[] nums, int index, ArrayList<Integer> list, boolean[] visited){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                backtracking(nums, i + 1, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}